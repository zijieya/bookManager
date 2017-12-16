package bookmanager.web.dao;

import bookmanager.web.model.Book;

import java.util.List;

/*
* @Description: 图书数据库操作
* */
public interface BookDao {
    void updateBook(Book book);//更新图书信息
    void insertBook(Book book);//插入书籍信息
    Book getBook(int bookId);//通过bookId查询书籍
    List<Book> listBookByName(String bookName);//列出书名相同的书籍信息
    List<Book> listAllBook();//列出所有书籍
}
