package bookmanager.web.controller;

import bookmanager.web.model.Book;
import bookmanager.web.model.User;
import bookmanager.web.service.BookService;
import bookmanager.web.service.BorrowService;
import bookmanager.web.service.UserService;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
@SessionAttributes({"userId","bookId"})

//管理员控制器
@Controller
public class AdminController {
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;
    @Autowired
    BorrowService borrowService;

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/admin/index",method = GET)
    public String index(){
        return "admin/index";
    }

    /**
     * 增加图书
     * @return
     */
    @RequestMapping(value = "/admin/addbook",method = GET)
    public String addBook(){
        return "admin/addbook";
    }
    /**
     * 增加图书操作
     * @return
     */
    @RequestMapping(value = "/admin/addbook",method = POST)
    public String addBook(Book book){
        bookService.insertBook(book);
        return "admin/booklist";
    }
    /**
     * 增加用户
     * @return
     */
    @RequestMapping(value = "/admin/adduser",method = GET)
    public String addUser(){
        return "admin/adduser";
    }

    /**
     * 处理增加用户操作
     * @param user
     * @return
     */
    @RequestMapping(value = "/admin/adduser",method = POST)
    public String addUser(User user){
        userService.insertUser(user);
        return "admin/userlist";
    }

    /**
     * 用户黑名单
     * @return
     */
    @RequestMapping(value = "/admin/blacklistuser",method = GET)
    public String blacklistUser(){
        return "admin/blacklistuser";
    }

    /**
     * 修改图书信息
     * @param bookId
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/bookmanage/{bookId}",method= GET)
    public String bookManage(@PathVariable("bookId") int bookId,Model model){
        model.addAttribute("bookId",bookId);//存储图书编号
        return "admin/bookmanage";
    }

    /**
     * 删除图书操作
     * @param bookId
     * @return
     */
    @RequestMapping(value = "/admin/deletebook/{bookId}",method= GET)
    public String deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBook(bookId);
        return "admin/booklist";
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping(value = "/admin/deleteuser/{userId}",method= GET)
    public String deleteUser(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
        return "admin/userlist";
    }

    /**
     * 超期管理
     * @return
     */
    @RequestMapping(value = "/admin/overduemanage",method= GET)
    public String overdueManage(){
        return "admin/overduemanage";
    }

    /**
     * 续借管理
     * @return
     */
    @RequestMapping(value = "/admin/rebookmanage",method= GET)
    public String rebookManage(){
        return "admin/rebookmanage";
    }

    /**
     * 列出图书页面
     * @return
     */
    @RequestMapping(value = "/admin/booklist",method= GET)
    public String listBook(){
        return "admin/booklist";
    }

    /**
     * 图书分页
     * @param bookName
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @RequestMapping(value = "/admin/listbooks",produces = "application/json; charset=utf-8",method = GET)
    @ResponseBody
    public String listBook(@RequestParam(value = "bookName",required=false) String bookName, @RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber){
        int total=bookService.getBookNumber(bookName);
        List<Book> bookList=bookService.findBookByPage(bookName,pageNumber,pageSize);
        Gson gson=new Gson();
        Map<String,Object> file=new HashMap<String, Object>() ;
        file.put("total",total);
        file.put("rows",bookList);
        return gson.toJson(file);
    }

    /**
     * 处理图书更新操作
     * @param book
     * @param bookId
     * @return
     * TODO 此时不能处理空值
     */
    @RequestMapping(value = "/admin/bookmanage",method= POST)
    public String bookManage(Book book,@SessionAttribute("bookId") int bookId) {
        book.setBookId(bookId);
        bookService.updateBook(book);
        return "/admin/booklist";
    }
    @RequestMapping(value = "/admin/listuser",method= GET)
    public String listUser(){
        return "/admin/userlist";
    }
    @RequestMapping(value = "/admin/listusers",produces = "application/json; charset=utf-8",method = GET)
    @ResponseBody
    public String listUsers( @RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber){
        int total=userService.getUserNumber();
        List<User> userList=userService.listUserByPage(pageNumber,pageSize);
        Gson gson=new Gson();
        Map<String,Object> file=new HashMap<String, Object>() ;
        file.put("total",total);
        file.put("rows",userList);
        return gson.toJson(file);
    }

    /**
     * 显示修改用户信息界面
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/usermanage/{userId}",method= GET)
    public String userManage(@PathVariable("userId") int userId, Model model){
        model.addAttribute("userId",userId);
        return "/admin/usermanage";
    }

    /** TODO 此时不能处理空值
     * 修改用户信息操作
     * @param user
     * @param userId
     * @return
     */
    @RequestMapping(value = "/admin/usermanage",method= POST)
    public String userManage(User user,@SessionAttribute("userId") int userId){
        user.setUserId(userId);
        userService.updateUser(user);
        return "/admin/userlist";
    }
}
