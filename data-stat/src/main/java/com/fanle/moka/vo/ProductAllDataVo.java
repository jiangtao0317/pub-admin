package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class ProductAllDataVo {

    @Excel(name="日期")
    private String date ;
    @Excel(name="阅读时长(秒)")
    private long readSecSum =0 ;
    @Excel(name="使用时长(秒)")
    private long onlineSum =0;
    @Excel(name="阅读用户")
    private long readUserSum=0;
    @Excel(name="在读书籍")
    private long bookUvSum =0;
    @Excel(name="登录启动")
    private long loginAppStartPvSum=0 ;
    @Excel(name="账号登录人数")
    private long accountLoginSum =0;
    @Excel(name="游客登录")
    private long loginGuestSum =0;
    @Excel(name="app内分享PV")
    private long shareAppPvSum =0;
    @Excel(name="app内分享UV")
    private long shareAppUvSum =0 ;
}
