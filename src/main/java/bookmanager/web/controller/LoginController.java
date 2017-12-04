package bookmanager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {
    //处理/login的get请求
    @RequestMapping(value = "/login",method = GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/login",method = POST)
    public String forget(){
        return "user/"+"profile";
    }



}
