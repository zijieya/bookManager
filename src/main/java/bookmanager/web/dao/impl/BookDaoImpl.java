package bookmanager.web.dao.impl;

import bookmanager.web.dao.BookDao;
import bookmanager.web.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    private JdbcOperations jdbcOperations;
    @Autowired
    BookDao bookDao;
    //构造器注入
    @Autowired
    public BookDaoImpl(JdbcOperations jdbcOperations){
        this.jdbcOperations=jdbcOperations;
    }
    @Override
    public void updateBook(Book book) {
        try{
            String sql="update book set book_name=?,book_author=?,book_press=?,book_price=?,book_description=?,book_photouri=?,remain=? where bookid=?";
            Object[] params={book.getBookName(),book.getBookAuthor(),book.getBookPress(),book.getBookPrice(),book.getBookDescription(),book.getBookPhotoUri(),book.getRemain(),book.getBookId()};
            jdbcOperations.update(sql,params);
        }
        catch (EmptyResultDataAccessException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void insertBook(Book book) {
        try{
            String sql="insert into book(book_name,book_author,book_press,book_price,book_description,book_photouri,remain) VALUE (?,?,?,?,?,?,?)";
            Object[] params={book.getBookName(),book.getBookAuthor(),book.getBookPress(),book.getBookPrice(),book.getBookDescription(),book.getBookPhotoUri(),book.getRemain()};
            jdbcOperations.update(sql,params);
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Book getBook(int bookId) {
        try{
            String sql="select * from book where bookId=?";
            Object[] params={bookId};
            return jdbcOperations.queryForObject(sql, params, new RowMapper<Book>() {
                @Override
                public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Book book=new Book();
                    book.setBookId(rs.getInt("bookid"));
                    book.setBookName(rs.getString("book_name"));
                    book.setBookAuthor(rs.getString("book_author"));
                    book.setBookPress(rs.getString("book_press"));
                    book.setBookPrice(rs.getFloat("book_price"));
                    book.setBookDescription(rs.getString("book_description"));
                    book.setBookPhotoUri(rs.getString("book_photouri"));
                    book.setRemain(rs.getInt("remain"));
                    return book;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Book> listBookByNameAndPage(String bookName,int startIndex,int end) {
        try{
            String sql="select * from book where book_name=? limit ?,?";
            Object[] params={bookName,startIndex,end};
            return jdbcOperations.query(sql, params, new RowMapper<Book>() {
                @Override
                public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Book book=new Book();
                    book.setBookId(rs.getInt("bookid"));
                    book.setBookName(rs.getString("book_name"));
                    book.setBookAuthor(rs.getString("book_author"));
                    book.setBookPress(rs.getString("book_press"));
                    book.setBookPrice(rs.getFloat("book_price"));
                    book.setBookDescription(rs.getString("book_description"));
                    book.setBookPhotoUri(rs.getString("book_photouri"));
                    book.setRemain(rs.getInt("remain"));
                    return book;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Book> listAllBook() {
        try{
            String sql="select * from book ";
            return jdbcOperations.query(sql, new RowMapper<Book>() {
                @Override
                public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Book book=new Book();
                    book.setBookId(rs.getInt("bookid"));
                    book.setBookName(rs.getString("book_name"));
                    book.setBookAuthor(rs.getString("book_author"));
                    book.setBookPress(rs.getString("book_press"));
                    book.setBookPrice(rs.getFloat("book_price"));
                    book.setBookDescription(rs.getString("book_description"));
                    book.setBookPhotoUri(rs.getString("book_photouri"));
                    book.setRemain(rs.getInt("remain"));
                    return book;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Book> listBook(int startIndex, int pageSize) {
        try{
            String sql="select * from book limit ?,?  ";
            Object[] params={startIndex,pageSize};
            return jdbcOperations.query(sql,params, new RowMapper<Book>() {
                @Override
                public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Book book=new Book();
                    book.setBookId(rs.getInt("bookid"));
                    book.setBookName(rs.getString("book_name"));
                    book.setBookAuthor(rs.getString("book_author"));
                    book.setBookPress(rs.getString("book_press"));
                    book.setBookPrice(rs.getFloat("book_price"));
                    book.setBookDescription(rs.getString("book_description"));
                    book.setBookPhotoUri(rs.getString("book_photouri"));
                    book.setRemain(rs.getInt("remain"));
                    return book;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Book> listBookByName(String bookName) {
        try{
            String sql="select * from book where book_name=?";
            Object[] params={bookName};
            return jdbcOperations.query(sql, params, new RowMapper<Book>() {
                @Override
                public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Book book=new Book();
                    book.setBookId(rs.getInt("bookid"));
                    book.setBookName(rs.getString("book_name"));
                    book.setBookAuthor(rs.getString("book_author"));
                    book.setBookPress(rs.getString("book_press"));
                    book.setBookPrice(rs.getFloat("book_price"));
                    book.setBookDescription(rs.getString("book_description"));
                    book.setBookPhotoUri(rs.getString("book_photouri"));
                    book.setRemain(rs.getInt("remain"));
                    return book;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int getBookNumber() {
        return bookDao.listAllBook().size();
    }

    @Override
    public int getBookNumber(String bookName) {
        return bookDao.listBookByName(bookName).size();
    }

    @Override
    public void deleteBook(int bookId) {
        try{
            String sql="delete  from book where bookid=?";
            Object[] params={bookId};
            jdbcOperations.update(sql,params);
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }
}
