package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class DynamicVo {

    @Excel(name = "动态ID")
    private String dynamicId ;
    @Excel(name = "动态内容")
    private String content ;
    @Excel(name = "日期")
    private String date ;
    @Excel(name = "PV")
    private long pv ;
    @Excel(name = "UV")
    private long uv ;

}
