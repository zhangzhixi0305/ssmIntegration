package com.zhixi.service;

import com.zhixi.dao.BooksMapper;
import com.zhixi.pojo.Books;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    // 业务层service调dao层
    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    public int addBook(Books book) {
        return booksMapper.addBook(book);
    }

    public int delBook(int id) {
        return booksMapper.delBook(id);
    }

    public Books queryBookById(int id) {
        return booksMapper.queryBookById(id);
    }

    public int updateBook(Books book) {
        return booksMapper.updateBook(book);
    }

    public List<Books> queryBooks() {
        return booksMapper.queryBooks();
    }

    public Books queryBookByName(String bookName) {
        return booksMapper.queryBookByName(bookName);
    }
}
