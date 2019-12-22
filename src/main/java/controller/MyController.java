package controller;


import com.google.gson.Gson;
import entity.Wxuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import serviceimpl.WxuserServiceImpl;
import util.RestTemplateBean;
import util.WeChatSession;


@RestController
public class MyController {

    @Autowired
    WxuserServiceImpl wsi;

    @Autowired
    RestTemplateBean rtb;

    @Autowired
    RestTemplate restTemplate;

@RequestMapping(value="/my",produces = "application/json;charset=utf-8")
    public String my(){

    return "江雨哲";
}

    @RequestMapping(value="/insertSelective",produces = "application/json;charset=utf-8")

    public int insertSelective(){

        Wxuser wxuser=new Wxuser();

        wxuser.setOpenid("123");
        return wsi.insertSelective(wxuser);

    }

    @RequestMapping(value="/wxlogin",method= RequestMethod.POST)
    public String wxlogin(String code){
        System.out.println("------"+code);
        rtb.setCode(code);
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+rtb.getAppid()+
                "&secret="+rtb.getSecret()+"&js_code="+ rtb.getCode() +"&grant_type="+rtb.getGrant_type();
        String openid=null;
        ResponseEntity<String>  responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        if(responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK){
            String sessionData = responseEntity.getBody();
            Gson gson = new Gson();
            //解析从微信服务器获得的openid和session_key;
            WeChatSession weChatSession = gson.fromJson(sessionData,WeChatSession.class);
            //获取用户的唯一标识
            openid = weChatSession.getOpenid();
            //获取会话秘钥
            String session_key = weChatSession.getSession_key();
            //下面就可以写自己的业务代码了
            //最后要返回一个自定义的登录态,用来做后续数据传输的验证

            System.out.println("===="+openid+"*****"+session_key);

            Wxuser user=new Wxuser();

            if(openid!=null){

            if(wsi.selectByOpenId(openid)==null){
                user.setOpenid(openid);
                user.setProvince("陈凯");
                wsi.insertSelective(user);
                return user.getProvince();
            }
            }



        }

          return wsi.selectByOpenId(openid).getProvince();


    }




}
