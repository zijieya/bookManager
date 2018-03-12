package bookmanager.web.dao.impl;

import bookmanager.web.dao.BorrowHistoryDao;
import bookmanager.web.model.Borrow;
import bookmanager.web.model.BorrowHistory;
import bookmanager.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BorrowHistoryDaoImpl implements BorrowHistoryDao {
    @Autowired
    JdbcOperations jdbcOperations;
    @Override
    public List<BorrowHistory> listAllBorrowHistory() {
        try{
            String sql="select * from borrowhistory";
            return jdbcOperations.query(sql, new RowMapper<BorrowHistory>() {
                @Override
                public BorrowHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
                    BorrowHistory borrowHistory=new BorrowHistory();
                    borrowHistory.setBorrowHistoryId(rs.getInt("borrowhistoryid"));
                    borrowHistory.setUserId(rs.getInt("userid"));
                    borrowHistory.setBookid(rs.getInt("bookid"));
                    borrowHistory.setOperation(rs.getString("operation"));
                    borrowHistory.setOperationDate(rs.getDate("operationdate"));
                    return borrowHistory;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BorrowHistory> listAllBorrowHistoryByUser(User user) {
        try{
            String sql="select * from borrowhistory where userid=?";
            Object[] params={user.getUserId()};
            return jdbcOperations.query(sql,params, new RowMapper<BorrowHistory>() {
                @Override
                public BorrowHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
                    BorrowHistory borrowHistory=new BorrowHistory();
                    borrowHistory.setBorrowHistoryId(rs.getInt("borrowhistoryid"));
                    borrowHistory.setUserId(rs.getInt("userid"));
                    borrowHistory.setBookid(rs.getInt("bookid"));
                    borrowHistory.setOperation(rs.getString("operation"));
                    borrowHistory.setOperationDate(rs.getDate("operationdate"));
                    return borrowHistory;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertBorrowHistory(BorrowHistory borrowHistory) {

    }
}
