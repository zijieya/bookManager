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
    List<Book> listBookByNameAndPage(String bookName,int startIndex,int end);//列出书名相同的书籍信息
    List<Book> listAllBook();//列出所有书籍
    List<Book> listBook(int startIndex,int end);//列出某一范围的书籍信息
    List<Book> listBookByName(String bookName);//查找书籍
    int getBookNumber();//获得书籍数目
    int getBookNumber(String bookName);
}
