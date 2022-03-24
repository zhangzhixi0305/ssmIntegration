package com.zhixi.dao;

import com.zhixi.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangzhixi
 */
public interface BooksMapper {
    /**
     * 增加一本书
     * @param book
     * @return
     */
    int addBook(Books book);

    /**
     * 删除一本书
     * @param id 书籍ID
     * @return 书籍是否成功删除
     */
    int delBook(@Param("bookId") int id);

    /**
     * 查询一本书
     * @param id 书籍ID
     * @return 返回查询到的书籍
     */
    Books queryBookById(int id);

    /**
     * 更新一本书
     * @param book 书籍对象
     * @return 返回更新后的书籍对象
     */
    int updateBook(Books book);

    /**
     * 查询所有的书
     * @return 返回查询到所有的书籍对象
     */
    List<Books> queryBooks();

    /**
     * 根据书名查询书籍
     * @param bookName 书籍名称
     * @return 查询到的书籍
     */
    Books queryBookByName(@Param("bookName") String bookName);

    /**
     * 根据id删除书籍，其实执行的是update
     * @param id 书籍ID
     */
    int updateBookByCount(int id);
}
