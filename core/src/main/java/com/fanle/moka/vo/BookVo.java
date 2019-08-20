package com.fanle.moka.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-06-22 10:10
 **/

@Data
@AllArgsConstructor
public class BookVo {
    private String bookid ;
    private String typename ;
    private String tags;
}
