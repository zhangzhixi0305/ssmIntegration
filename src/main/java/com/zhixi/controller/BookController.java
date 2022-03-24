package com.zhixi.controller;

import com.zhixi.pojo.Books;
import com.zhixi.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhixi
 */
@Controller
@RequestMapping("/books")
public class BookController {

    /**
     * controller调service层
     */
    @Autowired
    @Qualifier("booksService")
    private BooksService booksService;

    /**
     * 1、查询全部的书籍，并跳转到书籍展示页面
     *
     * @param model 模型和视图，既可以携带数据信息，也可以携带视图信息
     * @return 查询到的全部书籍数据
     */
    @RequestMapping("/allBook")
    public String queryBooks(Model model) {
        List<Books> list = booksService.queryBooks();

        model.addAttribute("list", list);
        return "queryAllBookPage";
    }

    /**
     * 2、添加书籍页面
     *
     * @return 添加书籍的JSP页面
     */
    @RequestMapping("/toBookPage")
    public String toBookPage() {
        return "addBookPage";
    }

    /**
     * 2.1、添加书籍
     *
     * @param books 书籍对象
     * @return 书籍是否成功
     */
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        // 添加书籍
        booksService.addBook(books);
        // 跳转到查询全部书籍的页面【使用重定向】
        return "redirect:/books/allBook";
    }

    /**
     * 3、修改书籍页面
     *
     * @param id    书籍ID
     * @param model 模型和视图，既可以携带数据信息，也可以携带视图信息
     * @return 修改书籍的页面
     */
    @RequestMapping("/updateBookPage")
    // 这个id是从jsp页面拿到的，可以知道是对哪个用户进行修改数据
    public String updateBook(int id, Model model) {
        Books books = booksService.queryBookById(id);
        model.addAttribute("QUpdate", books);
        return "updateBookPage";
    }

    /**
     * 3.1、修改书籍
     *
     * @param books 要修改的书籍对象
     * @return 修改书籍的页面
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Books books) {
        booksService.updateBook(books);
        // 返回书籍首页
        return "redirect:/books/allBook";
    }

    /**
     * 4、删除书籍,删除完成后跳转到书籍首页
     *
     * @param id 要删除的书籍ID
     * @return 到首页【所有的书籍页面】
     */
    @RequestMapping("/delBook")
    public String delBook(int id) {
        booksService.delBook(id);
        return "redirect:/books/allBook";
    }


    /**
     * 5、根据id查找书籍
     *
     * @param id    书籍ID
     * @param model 模型和视图，既可以携带数据信息，也可以携带视图信息
     * @return 查询到的书籍页面
     */
    @RequestMapping("/queryById")
    // RequestParam是为了设置前端过来的请求与参数名不一致的情况
    public String queryBookById(@RequestParam("bookById") String id, Model model) {
        List<Books> list = new ArrayList<Books>();
        if ("".equals(id)) {
            list = booksService.queryBooks();
            model.addAttribute("list", list);
            model.addAttribute("errorById", "请您输入正确的书籍ID！");
            return "queryAllBookPage";
        }

        // 根据id查询
        Books books = booksService.queryBookById(Integer.parseInt(id));
        list.add(books);

        if (books == null) {// 没有查询到书籍，就回到书籍首页并显示错误信息
            list = booksService.queryBooks();
            model.addAttribute("errorById", "没有查询到书籍！");
        }

        model.addAttribute("list", list);
        return "queryAllBookPage";
    }

    /**
     * 6、根据书名查找书籍
     *
     * @param bookName 书籍名称
     * @param model    模型和视图，既可以携带数据信息，也可以携带视图信息
     * @return 查询到的书籍对象
     */
    @RequestMapping("/queryByName")
    public String queryBookByName(@RequestParam("bookName") String bookName, Model model) {
        List<Books> list = new ArrayList<Books>();
        /*如果用户输入的书名是空字符串，返回到所有的书籍页面*/
        if ("".equals(bookName)) {
            list = booksService.queryBooks();
            model.addAttribute("list", list);
            return "queryAllBookPage";
        }

        /*这里做字符串拼接可以方式SQL注入的风险*/
        Books books = booksService.queryBookByName("%" + bookName + "%");
        list.add(books);

        /*没有查询到书籍，就回到书籍首页并显示错误信息*/
        if (books == null) {
            list = booksService.queryBooks();
            model.addAttribute("errorByName", "没有查询到书籍！");
        }
        model.addAttribute("list", list);
        return "queryAllBookPage";
    }
}
