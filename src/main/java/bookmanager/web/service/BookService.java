package bookmanager.web.service;

import bookmanager.web.model.Book;
import bookmanager.web.model.Page;

import java.util.List;

public interface BookService {
    List<Book> findBookByPage(String boookName,int pageNumber, int pageSize);//找到书名的一页书籍
    int getBookNumber(String bookName);//得到某本书的数量
    Book getBook(int bookId);//找到某本书
    void updateBook(Book book);//更新某本书的信息
}
