package bookmanager.web.controller;

import bookmanager.web.model.User;
import bookmanager.web.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
// 登录注册控制器
@Controller
public class LoginAndRegisterController {
    private UserDaoService userDaoService;
    @Autowired
    LoginAndRegisterController(UserDaoService userDaoService){
        this.userDaoService=userDaoService;
    }
    //处理/login的get请求
    @RequestMapping(value = "/",method = GET)
    public String login(){
        return "login";
    }
   @RequestMapping(value = "/login.do",method = POST)
   public String login(@Valid  User user, Errors errors){
        User user1=userDaoService.getLoginUser(user);
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        if(user1!=null)
            return "user/profile";
        else
            return "login";
    }
    @RequestMapping(value = "/register",method = GET)
    public String register(){
       return "register";
    }
    @RequestMapping(value = "/forget",method = GET)
    public String forget(){
        return "forget";
    }
    @RequestMapping(value = "/confirm",method = GET)
    public String comfirm(){
        return "confirm";
    }
    @RequestMapping(value = "/resetpassword",method = GET)
    public String resetPassword(){
        return "resetpassword";
    }

}
