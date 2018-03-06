package bookmanager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
//用户控制器
@Controller
public class UserController {
    @RequestMapping(value = "/user/profile",method = GET)
    public String profile(){
        return "user/profile";
    }
    @RequestMapping(value = "/user/rebook",method = GET)
    public String rebook(){
        return "user/rebook";
    }
    @RequestMapping(value = "/user/returnbook",method = GET)
    public String returnBooks(){
        return "user/returnbooks";
    }
    @RequestMapping(value = "/user/searchbook",method = GET)
    public String searchBook(){
        return "user/searchbook";
    }
    @RequestMapping(value = "/user/bookhistory",method = GET)
    public String bookHistory(){
        return "user/bookhistory";
    }
}
