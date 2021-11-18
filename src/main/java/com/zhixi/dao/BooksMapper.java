package com.zhixi.dao;

import com.zhixi.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangzhixi
 */
public interface BooksMapper {
    // 增加一本书
    int addBook(Books book);

    // 删除一本书
    int delBook(@Param("bookId") int id);

    // 查询一本书
    Books queryBookById(int id);

    // 更新一本书
    int updateBook(Books book);

    // 查询所有的书
    List<Books> queryBooks();

    // 根据书名查询书籍
    Books queryBookByName(@Param("bookName") String bookName);
}
