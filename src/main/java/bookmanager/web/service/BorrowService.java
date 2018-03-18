package bookmanager.web.service;

import bookmanager.web.model.Book;
import bookmanager.web.model.Borrow;
import bookmanager.web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BorrowService {
    void borrowBook(Borrow borrow, int bookId);//借书时插入借阅记录 更新图书信息

    List<Borrow> listBorrowedBook(User user);//列出某一用户的书籍

    List<Borrow> listBorrowByPage(int pageNumber, int pageSize);//列出一页已借书籍

    List<Borrow> listBorrowByPageAndUser(int userId, int pageNumber, int pageSize);//列出某一用户一页已借书籍

    void deleteBorrow(int borrowId);//删除某条借阅信息

    void reBorrowBook(int borrowId);//续借图书

    List<Borrow> listAllBorrow();//列出所有的借阅信息
}
