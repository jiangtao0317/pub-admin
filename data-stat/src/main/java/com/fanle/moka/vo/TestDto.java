package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;

import java.math.BigDecimal;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-05-08 16:25
 **/

public class TestDto {

    @Excel(name = "金额")
    private BigDecimal money = BigDecimal.ZERO;

    @Excel(name = "用户数")
    private Long ids = 0L;

    @Excel(name = "日期")
    private String date ;

//    @Excel(name = "平台")
//    private String platform ;

    @Excel(name = "书籍数量")
    private long bookNum ;

    public long getBookNum() {
        return bookNum;
    }

    public void setBookNum(long bookNum) {
        this.bookNum = bookNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public String getPlatform() {
//        return platform;
//    }
//
//    public void setPlatform(String platform) {
//        this.platform = platform;
//    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Long getIds() {
        return ids;
    }

    public void setIds(Long ids) {
        this.ids = ids;
    }

}
