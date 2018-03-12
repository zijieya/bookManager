package bookmanager.web.model;

import java.util.Date;

public class BorrowHistory {
    private int borrowHistoryId;//历史编号
    private int userId;//用户编号
    private int bookid;//图书编号
    private String operation;//操作
    private Date operationDate;//操作时间

    public int getBorrowHistoryId() {
        return borrowHistoryId;
    }

    public void setBorrowHistoryId(int borrowHistoryId) {
        this.borrowHistoryId = borrowHistoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }
}
