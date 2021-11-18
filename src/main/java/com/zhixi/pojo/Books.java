package com.zhixi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangzhixi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String detail;
}
