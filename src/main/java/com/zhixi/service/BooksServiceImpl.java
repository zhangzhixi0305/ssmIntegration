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
        return booksMapper.delBook(id);
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
}
