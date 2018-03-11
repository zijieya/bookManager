package bookmanager.web.service;

import bookmanager.web.model.Book;
import bookmanager.web.model.Page;

import java.util.List;

public interface BookService {
    List<Book> findBookByPage(String boookName,int pageNumber, int pageSize);
    int getBookNumber(String bookName);
}
