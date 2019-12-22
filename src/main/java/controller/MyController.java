package controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

@RequestMapping(value="/my",produces = "application/json;charset=utf-8")
    public String my(){

    return "江雨哲";
}




}
