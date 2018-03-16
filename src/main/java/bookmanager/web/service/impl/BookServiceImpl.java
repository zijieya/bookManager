package bookmanager.web.service.impl;

import bookmanager.web.dao.BookDao;
import bookmanager.web.model.Book;
import bookmanager.web.model.Page;
import bookmanager.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    /**
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public List<Book> findBookByPage(String bookName,int pageNumber, int pageSize) {
        int totalRecord=bookDao.getBookNumber(bookName);//获得全部记录
        Page page=new Page(pageNumber,pageSize,totalRecord);
        int startIndex=page.getStartIndex();
        if(bookName==null)
            return bookDao.listBook(startIndex,pageSize);
        else
            return bookDao.listBookByNameAndPage(bookName,startIndex,pageSize);
    }

    @Override
    public int getBookNumber(String bookName) {
        // 如果没有书名 则显示所有书籍的数目 反之则显示相应书名的数目
         if(bookName==null)
            return bookDao.listAllBook().size();
        else
            return bookDao.listBookByName(bookName).size();
    }

    @Override
    public Book getBook(int bookId) {
        return bookDao.getBook(bookId);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void insertBook(Book book) {
        bookDao.insertBook(book);
    }

    @Override
    public void deleteBook(int bookId) {
        bookDao.deleteBook(bookId);
    }
}

