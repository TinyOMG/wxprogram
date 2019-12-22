package controller;


import entity.Wxuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serviceimpl.WxuserServiceImpl;

@RestController
public class MyController {

    @Autowired
    WxuserServiceImpl wsi;

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
