package bookmanager.web.controller;

import bookmanager.web.dao.BookDao;
import bookmanager.web.model.Book;
import bookmanager.web.service.BookService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

//用户控制器
@Controller
public class UserController {
    @Autowired
    BookService bookService;
    public UserController(){

    }
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
    @RequestMapping(value = "/user/showbook",method = GET)
    public String showBook(){

        return "user/searchbook";
    }
    @RequestMapping(value = "/user/searchbooks",produces = "application/json; charset=utf-8",method = GET)
    @ResponseBody
    public String searchBook(@RequestParam(value = "bookName",required=false) String bookName,@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
      /*  int total;//总条数
        if(bookName==null)
            total=bookService.getBookNumber();
        else*/
           int total=bookService.getBookNumber(bookName);
        List<Book> bookList=bookService.findBookByPage(bookName,pageNumber+1,pageSize);
        Gson gson=new Gson();
        Map<String,Object> file=new HashMap<String, Object>() ;
        file.put("total",total);
        file.put("rows",bookList);
        System.out.println(bookName);
        return gson.toJson(file);
    }
}
