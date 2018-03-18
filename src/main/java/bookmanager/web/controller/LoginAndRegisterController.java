package bookmanager.web.controller;

import bookmanager.web.model.User;
import bookmanager.web.model.UserRole;
import bookmanager.web.service.UserRoleService;
import bookmanager.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
// 登录注册控制器
@Controller
@SessionAttributes({"user","number"})
public class LoginAndRegisterController {
    @Autowired
    JavaMailSender javaMailSender; //字段注入
    private UserService userService;
    @Autowired
    UserRoleService userRoleService;
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
           = "/login",method = POST)
   public String login(  User user, Model model){
        User user1= userService.getLoginUser(user);
        if(user1!=null)
        {
            UserRole userRole=userRoleService.getUserRole(user1.getUserId());//获得用户权限信息
            model.addAttribute("user",user1);//将数据传入模型中
            if(userRole.getUserType()==0){//普通用户
                return "user/searchbook";//用户登录成功则跳转到查找书籍界面
            }
            if(userRole.getUserType()==1){
                return "admin/booklist";//管理员登录成功则跳到用户首页
            }
            if(userRole.getUserType()==2){
                return "login";//黑名单用户无法登录
            }
        }
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
    @RequestMapping(value = "/confirm",method = POST)
    public String getCode(String email,Model model){
        int number=userService.getCode(email);
        User user=userService.getUserByEmail(email);
        model.addAttribute("number",number);//存验证码
        model.addAttribute("user",user);//存用户信息
        return "confirm";
    }
    @RequestMapping(value = "/resetpassword",method = POST)
    public String resetPassword(@SessionAttribute("number") int number2, String number){
        if(number2==Integer.parseInt(number))
            return "resetpassword";
        else
            return "confirm";
    }

    /**
     * 更新密码
     * @param user
     * @param password
     * @return
     */
    @RequestMapping(value = "/newpassword",method = POST)
    public String getNewPassword(@SessionAttribute("user") User user ,String password){
        user.setPassword(password);
        userService.updateUser(user);//更新用户信息
        return "login";
    }
    @RequestMapping(value = "/register",method = POST)
    public String register(User user){
        userService.insertUser(user);
        return "login";
    }
}
