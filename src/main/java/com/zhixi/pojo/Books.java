package com.zhixi.pojo;

import java.io.Serializable;

/**
 * @author zhangzhixi
 */
@SuppressWarnings("all")
public class Books implements Serializable {
    private static final long serialVersionUID = -64654897315254L;
    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String detail;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(Integer bookCounts) {
        this.bookCounts = bookCounts;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookCounts=" + bookCounts +
                ", detail='" + detail + '\'' +
                '}';
    }
}
