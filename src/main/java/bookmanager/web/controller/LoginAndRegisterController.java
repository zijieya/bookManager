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
       /*if(errors.hasErrors())
           return "login";
       else
           return "user/profile";*/
        User user1=userDaoService.getLoginUser(user);
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        if(user1!=null)
            return "user/profile";
        else
            return "login";
    }
    @RequestMapping(value = "/register.jsp",method = GET)
    public String register(){
       return "register";
    }


}
