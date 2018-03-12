package bookmanager.web.dao;

import bookmanager.web.model.BorrowHistory;
import bookmanager.web.model.User;

import java.util.List;

public interface BorrowHistoryDao {
    List<BorrowHistory> listAllBorrowHistory();//列出所有的历史记录
    List<BorrowHistory> listAllBorrowHistoryByUser(User user);//列出某一用户的借阅历史
    void insertBorrowHistory(BorrowHistory borrowHistory);//插入借阅历史
}
