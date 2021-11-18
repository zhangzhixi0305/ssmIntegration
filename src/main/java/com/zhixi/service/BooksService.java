package com.zhixi.service;

import com.zhixi.pojo.Books;

import java.util.List;

/**
 * @author zhangzhixi
 */
public interface BooksService {
    // 增加一本书
    int addBook(Books book);

    // 删除一本书
    int delBook(int id);

    // 查询一本书
    Books queryBookById(int id);

    // 更新一本书
    int updateBook(Books book);

    // 查询所有的书
    List<Books> queryBooks();

    // 根据书名查询书籍
    Books queryBookByName(String bookName);
}
