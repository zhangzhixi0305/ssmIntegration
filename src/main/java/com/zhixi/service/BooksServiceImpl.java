package com.zhixi.service;

import com.zhixi.dao.BooksMapper;
import com.zhixi.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    /**
     * 业务层service调dao层
     */
    @Autowired
    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public int addBook(Books book) {
        return booksMapper.addBook(book);
    }

    @Override
    public int delBook(int id) {
        int updateCount = 0;
        /*1.先确定数据库中书籍的数量*/
        Books books = booksMapper.queryBookById(id);
        if (books.getBookCounts() <= 0) {
            booksMapper.delBook(id);
        } else {
            /*2.更新书籍数量*/
            updateCount = updateBookByCount(id);
        }
        /*更新成功返回1*/
        return updateCount;
    }

    @Override
    public Books queryBookById(int id) {
        return booksMapper.queryBookById(id);
    }

    @Override
    public int updateBook(Books book) {
        return booksMapper.updateBook(book);
    }

    @Override
    public List<Books> queryBooks() {
        return booksMapper.queryBooks();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return booksMapper.queryBookByName(bookName);
    }

    @Override
    public int updateBookByCount(int id) {
        return booksMapper.updateBookByCount(id);
    }
}
