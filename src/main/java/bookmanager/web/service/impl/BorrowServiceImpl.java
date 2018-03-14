package bookmanager.web.service.impl;

import bookmanager.web.dao.BookDao;
import bookmanager.web.dao.BorrowDao;
import bookmanager.web.model.*;
import bookmanager.web.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    private final static long SEVENDAYS=1000*60*60*24*7;//七天的毫秒数
    @Autowired
    BorrowDao borrowDao;//注入借阅操作
    @Autowired
    BookDao bookDao;//注入图书操作
    @Override
    public void borrowBook(Borrow borrow, int bookId) {
        Book book=bookDao.getBook(bookId);//获得这本书的信息
        book.setRemain(book.getRemain()-1);//图书数量减1
        bookDao.updateBook(book);//更新图书信息
        borrowDao.insertBorrow(borrow);//插入借阅信息
    }

    @Override
    public List<Borrow> listBorrowedBook(User user) {
        return borrowDao.listBorrowByUserId(user.getUserId());
    }

    @Override
    public List<Borrow> listBorrowByPage(int pageNumber, int pageSize) {
        int totalRecord=borrowDao.listAllBorrow().size();//全部记录数目
        Page page=new Page(pageNumber,pageSize,totalRecord);
        int startIndex=page.getStartIndex();
        return borrowDao.listBorrowByPage(startIndex,pageSize);
    }

    @Override
    public List<Borrow> listBorrowByPageAndUser(int userId, int pageNumber, int pageSize) {
        int totalRecord=borrowDao.listBorrowByUserId(userId).size();
        Page page=new Page(pageNumber,pageSize,totalRecord);
        int startIndex=page.getStartIndex();
        return borrowDao.listBorrowByPageAndUser(userId,startIndex,pageSize);
    }

    @Override
    public void deleteBorrow(int borrowId) {
        Borrow borrow=borrowDao.getBorrow(borrowId);//获取借阅信息
        borrowDao.updateBorrow(borrow);
        borrowDao.deleteBorrow(borrowId);
    }

    @Override
    public void reBorrowBook(int borrowId) {
        //获得那条借阅信息
        Borrow borrow=borrowDao.getBorrow(borrowId);
        System.out.println(borrow.getBookId());
        borrow.setReBorrowTimes(borrow.getReBorrowTimes()+1);//续借次数加1
        //更新还书时间
        Timestamp timestamp=borrow.getReturnTime();//获得还书时间栈
        Timestamp timestamp1=new Timestamp(timestamp.getTime()+SEVENDAYS);
        borrow.setReturnTime(timestamp1);
        borrowDao.updateBorrow(borrow);
    }
}
