package bookmanager.web.model;


import java.sql.Timestamp;

public class Borrow {
    private int borrowId;//借阅编号
    private int userId;//用户编号
    private int bookId;//图书编号
    private Timestamp borrowTime;//借阅时间
    private Timestamp returnTime;//还书时间
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

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public int getReBorrowTimes() {
        return reBorrowTimes;
    }

    public void setReBorrowTimes(int reBorrowTimes) {
        this.reBorrowTimes = reBorrowTimes;
    }
}
