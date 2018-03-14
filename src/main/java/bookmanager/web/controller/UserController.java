package bookmanager.web.controller;

import bookmanager.web.dao.BookDao;
import bookmanager.web.model.Book;
import bookmanager.web.model.Borrow;
import bookmanager.web.model.User;
import bookmanager.web.service.BookService;
import bookmanager.web.service.BorrowService;
import bookmanager.web.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

//用户控制器
@Controller
@SessionAttributes("user")
public class UserController {
    @Autowired
    BookService bookService;
    @Autowired
    BorrowService borrowService;
    @Autowired
    UserService userService;
    public UserController(){

    }
    @RequestMapping(value = "/user/profile",method = GET)
    public String profile(){
        return "user/profile";
    }
    @RequestMapping(value = "/user/reborrow/{borrowId}",method = GET)
    public String reBorrow(@PathVariable("borrowId") int borrowId){//续借则时间加七天
        borrowService.reBorrowBook(borrowId);
        return "user/borrowedbook";
    }
    @RequestMapping(value = "/user/returnbook",method = GET)
    public String returnBook(@RequestParam("borrowId") int borrowId ,@RequestParam("bookId") int bookId){
        //还书则删除此条借阅信息  并且图书数量加1
        borrowService.deleteBorrow(borrowId);
        Book book=bookService.getBook(bookId);
        book.setRemain(book.getRemain()+1);//图书数量加1;
        bookService.updateBook(book);
        return "/user/borrowedbook";
    }
    @RequestMapping(value = "/user/searchbook",method = GET)
    public String searchBook(){
        return "user/searchbook";
    }
    @RequestMapping(value = "/user/bookhistory",method = GET)
    public String bookHistory(){
        return "user/bookhistory";
    }
    /**
     *  获取图书表格所需要的数据
     * @param bookName
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @RequestMapping(value = "/user/searchbooks",produces = "application/json; charset=utf-8",method = GET)
    @ResponseBody
    public String searchBook(@RequestParam(value = "bookName",required=false) String bookName,@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {

        int total=bookService.getBookNumber(bookName);
        List<Book> bookList=bookService.findBookByPage(bookName,pageNumber,pageSize);
        Gson gson=new Gson();
        Map<String,Object> file=new HashMap<String, Object>() ;
        file.put("total",total);
        file.put("rows",bookList);
        return gson.toJson(file);
    }

    /**
     * 借书操作
     * @param bookId
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/borrowbook/{bookId}",method = GET)
    public String borrowbook(@PathVariable("bookId") int bookId,@SessionAttribute("user") User user){
        System.out.println(user.getUsername());
        //计算还书日期 一本书可以借7天
        Date date=new Date();
        Timestamp timestamp=new Timestamp(date.getTime()+1000*60*60*24*7);
        Borrow borrow=new Borrow();
        borrow.setBookId(bookId);//设置图书id
        borrow.setUserId(user.getUserId());//设置图书编号
        borrow.setReturnTime(timestamp);
        borrowService.borrowBook(borrow,bookId);
        return "/user/searchbook";
    }

    /**
     * 显示借书页面
     * @return
     */
    @RequestMapping(value = "/user/borrowedbook",method = GET)
    public String borrowedbook(){
        return "/user/borrowedbook";
    }
    @RequestMapping(value = "/user/borrowedbooks",produces = "application/json; charset=utf-8",method = GET)
    @ResponseBody
    public String borrowedbook(@SessionAttribute("user") User user,@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber){
        List<Borrow> borrowList=borrowService.listBorrowedBook(user);//获得用户已经借的所有图书
        int total=borrowList.size();//获得总数
        List<Borrow> borrowList1=borrowService.listBorrowByPageAndUser(user.getUserId(),pageNumber,pageSize);
        Gson gson=new Gson();
        //生成满足bootstrap table的数据
        Map<String,Object> file=new HashMap<String, Object>() ;
        file.put("total",total);
        file.put("rows",borrowList1);
        return gson.toJson(file);
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping(value = "/user/password",method = GET)
    public String password(){
        return "/user/password";
    }
    @RequestMapping(value = "/user/password",method = POST)
    public String password(@RequestParam("password") String password,@SessionAttribute("user") User user){
        user.setPassword(password);//设置密码
        userService.updateUser(user);//更新用户信息
        return "login";//返回首页
    }
}
