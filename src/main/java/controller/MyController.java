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






}
