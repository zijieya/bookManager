package bookmanager.web.controller;

import bookmanager.web.model.User;
import bookmanager.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
// 登录注册控制器
@Controller
@SessionAttributes("user")
public class LoginAndRegisterController {
    @Autowired
    JavaMailSender javaMailSender; //字段注入
    private UserService userService;
    @Autowired
    LoginAndRegisterController(UserService userService){
        this.userService = userService;
    }
    //处理/login的get请求
    @RequestMapping(value = "/",method = GET)
    public String login(){
        return "login";
    }
   @RequestMapping(value
           = "/login.do",method = POST)
   public String login(  User user, Model model){
        User user1= userService.getLoginUser(user);
        if(user1!=null)
        {
            System.out.println(user1.getUsername());
            model.addAttribute("user",user1);//将数据传入模型中
            return "user/profile";
        }
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
    @RequestMapping(value = "/forget",method = POST)
    public String getCode(String email){
        userService.getCode(email);
        return "confirm";
    }

}
