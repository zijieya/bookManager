package bookmanager.web.dao;

import bookmanager.web.model.Borrow;

import java.util.List;

public interface BorrowDao {
    void updateBorrow(Borrow borrow);//更新借阅信息
    void insertBorrow(Borrow borrow);//插入借阅信息
    void deleteBorrow(String borrowId);//通过borrowId删除借阅信息
    List<Borrow> listAllBorrow();//列出所有的借阅信息
    List<Borrow> listBorrowByUserId(int userId);//列出某用户的借阅信息
}
