package bookmanager.web.dao.impl;

import bookmanager.web.dao.BorrowDao;
import bookmanager.web.model.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
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
            String sql="update borrow set userid=?,bookid=?,return_time=?,reborrow_times=? where borrowid=?";
            Object[] params={borrow.getUserId(),borrow.getBookId(),borrow.getReturnTime(),borrow.getReBorrowTimes(),borrow.getBorrowId()};
            jdbcOperations.update(sql,params);
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void insertBorrow(Borrow borrow) {
        try{
            String sql="insert into borrow(userid,bookid,return_time) values(?,?,?)";
            Object[] params={borrow.getUserId(),borrow.getBookId(),borrow.getReturnTime()};
            jdbcOperations.update(sql,params);
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBorrow(int borrowId) {
        try{
            String sql="delete  from borrow where borrowid=?";
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
                    borrow.setBorrowId(rs.getInt("borrowid"));
                    borrow.setUserId(rs.getInt("userid"));
                    borrow.setBookId(rs.getInt("bookid"));
                    borrow.setBorrowTime(rs.getTimestamp("borrow_time"));
                    borrow.setReturnTime(rs.getTimestamp("return_time"));
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
            String sql="select * from borrow where userid=?";
            Object[] params={userId};
            return jdbcOperations.query(sql,params, new RowMapper<Borrow>() {
                @Override
                public Borrow mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Borrow borrow=new Borrow();
                    borrow.setBorrowId(rs.getInt("borrowid"));
                    borrow.setUserId(rs.getInt("userid"));
                    borrow.setBookId(rs.getInt("bookid"));
                    borrow.setBorrowTime(rs.getTimestamp("borrow_time"));
                    borrow.setReturnTime(rs.getTimestamp("return_time"));
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
    public List<Borrow> listBorrowByPage(int startIndex, int pageSize) {
        try{
            String sql="select * from borrow limit ?,?";
            Object[] params={startIndex,pageSize};
            return jdbcOperations.query(sql,params, new RowMapper<Borrow>() {
                @Override
                public Borrow mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Borrow borrow=new Borrow();
                    borrow.setBorrowId(rs.getInt("borrowid"));
                    borrow.setUserId(rs.getInt("userid"));
                    borrow.setBookId(rs.getInt("bookid"));
                    borrow.setBorrowTime(rs.getTimestamp("borrow_time"));
                    borrow.setReturnTime(rs.getTimestamp("return_time"));
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
    public List<Borrow> listBorrowByPageAndUser(int userId, int startIndex, int pageSize) {
        try{
            String sql="select * from borrow where userid=? limit ?,?";
            Object[] params={userId,startIndex,pageSize};
            return jdbcOperations.query(sql,params, new RowMapper<Borrow>() {
                @Override
                public Borrow mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Borrow borrow=new Borrow();
                    borrow.setBorrowId(rs.getInt("borrowid"));
                    borrow.setUserId(rs.getInt("userid"));
                    borrow.setBookId(rs.getInt("bookid"));
                    borrow.setBorrowTime(rs.getTimestamp("borrow_time"));
                    borrow.setReturnTime(rs.getTimestamp("return_time"));
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
    public Borrow getBorrow(int borrowId) {
        try{
            String sql="select * from borrow where borrowid=?";
            Object[] params={borrowId};
            return jdbcOperations.queryForObject(sql, params, new RowMapper<Borrow>() {
                @Override
                public Borrow mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Borrow borrow=new Borrow();
                    borrow.setBorrowId(rs.getInt("borrowid"));
                    borrow.setBookId(rs.getInt("bookid"));
                    borrow.setUserId(rs.getInt("userid"));
                    borrow.setBorrowTime(rs.getTimestamp("borrow_time"));
                    borrow.setReturnTime(rs.getTimestamp("return_time"));
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
