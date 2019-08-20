package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-05-09 16:23
 **/

@Data
public class UserReadBookVo {

    @Excel(name = "userid")
    private String userid ;

    @Excel(name = "bookid")
    private String bookid ;
}
