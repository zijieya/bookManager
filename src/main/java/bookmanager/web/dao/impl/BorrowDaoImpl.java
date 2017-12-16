package bookmanager.web.dao.impl;

import bookmanager.web.dao.BorrowDao;
import bookmanager.web.model.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BorrowDaoImpl implements BorrowDao {
    private JdbcOperations jdbcOperations;
    //构造器注入
    @Autowired
    public BorrowDaoImpl(JdbcOperations jdbcOperations){
        this.jdbcOperations=jdbcOperations;
    }
    @Override
    public void updateBorrow(Borrow borrow) {
        try{
            String sql="update borrow set userid=?,bookid=?,borrow_time=?,return_time=?,reborrow_times=? where borrowid=?";
            Object[] params={borrow.getUserId(),borrow.getBookId(),borrow.getBorrowTime(),borrow.getReturnTime(),borrow.getReBorrowTimes(),borrow.getBorrowId()};
            jdbcOperations.update(sql,params);
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void insertBorrow(Borrow borrow) {
        try{
            String sql="insert into borrow(userid,bookid,reborrow_times) values(?,?,?)";
            Object[] params={borrow.getUserId(),borrow.getBookId(),borrow.getReBorrowTimes()};
            jdbcOperations.update(sql,params);
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBorrow(String borrowId) {
        try{
            String sql="delete * from borrow where borrowid=?";
            Object[] params={borrowId};
            jdbcOperations.update(sql,params);
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Borrow> listAllBorrow() {
        try{
            String sql="select * from borrow";
            return jdbcOperations.query(sql, new RowMapper<Borrow>() {
                @Override
                public Borrow mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Borrow borrow=new Borrow();
                    borrow.setBookId(rs.getInt("borrowid"));
                    borrow.setUserId(rs.getInt("userid"));
                    borrow.setBookId(rs.getInt("bookid"));
                    borrow.setBorrowTime(rs.getTime("borrow_time"));
                    borrow.setReturnTime(rs.getTime("return_time"));
                    borrow.setReBorrowTimes(rs.getInt("reborrow_times"));
                    return borrow;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Borrow> listBorrowByUserId(int userId) {
        try{
            String sql="select * from borrow";
            return jdbcOperations.query(sql, new RowMapper<Borrow>() {
                @Override
                public Borrow mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Borrow borrow=new Borrow();
                    borrow.setBookId(rs.getInt("borrowid"));
                    borrow.setUserId(rs.getInt("userid"));
                    borrow.setBookId(rs.getInt("bookid"));
                    borrow.setBorrowTime(rs.getTime("borrow_time"));
                    borrow.setReturnTime(rs.getTime("return_time"));
                    borrow.setReBorrowTimes(rs.getInt("reborrow_times"));
                    return borrow;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
