package bookmanager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
//管理员控制器
@Controller
public class AdminController {
    @RequestMapping(value = "/admin/index",method = GET)
    public String index(){
        return "admin/index";
    }
    @RequestMapping(value = "/admin/addbook",method = GET)
    public String addBook(){
        return "admin/addbook";
    }
    @RequestMapping(value = "/admin/adduser",method = GET)
    public String addUser(){
        return "admin/adduser";
    }
    @RequestMapping(value = "/admin/blacklistuser",method = GET)
    public String blacklistUser(){
        return "admin/blacklistuser";
    }
    @RequestMapping(value = "/admin/bookmanage",method= GET)
    public String bookManage(){
        return "admin/bookmanage";
    }
    @RequestMapping(value = "/admin/deletebook",method= GET)
    public String deleteBook(){
        return "admin/deletebook";
    }
    @RequestMapping(value = "/admin/deleteuser",method= GET)
    public String deleteUser(){
        return "admin/deleteuser";
    }
    @RequestMapping(value = "/admin/overduemanage",method= GET)
    public String overdueManage(){
        return "admin/overduemanage";
    }
    @RequestMapping(value = "/admin/rebookmanage",method= GET)
    public String rebookManage(){
        return "admin/rebookmanage";
    }

}
