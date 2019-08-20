package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;
import lombok.ToString;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-05-09 12:31
 **/

@Data
@ToString
public class RecommendVo {

    @Excel(name = "日期")
    private String date ;
    @Excel(name = "机推金额")
    private long aiMoney ;
    @Excel(name = "人推金额")
    private long manualMoney ;
    @Excel(name = "自然金额")
    private long normalMoney ;
    @Excel(name = "机推书籍数")
    private long aiBooks ;
    @Excel(name = "人推书籍数")
    private long manualBooks ;
    @Excel(name = "自然书籍数")
    private long normalBooks ;

}
