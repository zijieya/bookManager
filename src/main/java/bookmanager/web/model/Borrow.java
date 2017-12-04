package bookmanager.web.model;

import java.util.Date;

public class Borrow {
    private int borrowId;//借阅编号
    private int userId;//用户编号
    private int bookId;//图书编号
    private Date borrowTime;//借阅时间
    private Date returnTime;//还书时间
    private int reBorrowTimes;//续借次数

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public int getReBorrowTimes() {
        return reBorrowTimes;
    }

    public void setReBorrowTimes(int reBorrowTimes) {
        this.reBorrowTimes = reBorrowTimes;
    }
}
