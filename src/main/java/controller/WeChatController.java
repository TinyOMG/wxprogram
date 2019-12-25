package controller;

import entity.Wxuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import serviceimpl.WxuserServiceImpl;
import util.GetWeChatSession;
import util.RestTemplateBean;
import util.WeChatSession;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class WeChatController {
    @Autowired
    GetWeChatSession gws;
    @Autowired
    WxuserServiceImpl wsi;

    @Autowired
    RestTemplateBean rtb;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/wxlogin",method= RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public WeChatSession wxlogin(String code, String nickName, String city, String country, String gender, String province, String avatarUrl, String language){
        System.out.println("------"+code);
        System.out.println("------"+nickName);
        System.out.println("------"+language);

        WeChatSession weChatSession=gws.weChatSession(code);

            Wxuser user=new Wxuser();


        if(weChatSession.getOpenid()!=null){
              if(wsi.selectByOpenId(weChatSession.getOpenid())==null){

                  Date date=new Date();
                  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                  user.setOpenid(weChatSession.getOpenid());
                  user.setNickname(nickName);
                  user.setCity(city);
                  user.setCountry(country);
                  user.setGender(gender);
                  user.setProvince(province);
                  user.setAvatarurl(avatarUrl);
                  user.setLanguage(language);
                  user.setCtime(sdf.format(date));
                  wsi.insertSelective(user);
              }
            }

        return weChatSession;
    }

    @RequestMapping(value="/getUserInfo",method= RequestMethod.POST)
    public Wxuser getUserInfo(String openid, HttpServletRequest req){
        System.out.println("openid======"+openid);


    if(openid!=null){
    if(wsi.selectByOpenId(openid)!=null){
        System.out.println("通过openid查询到的对象"+wsi.selectByOpenId(openid).toString());
        return wsi.selectByOpenId(openid);
    }
}
        return null;
    }


}
