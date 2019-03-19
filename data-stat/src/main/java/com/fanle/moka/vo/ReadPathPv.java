package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class ReadPathPv {

    @Excel(name="日期")
    private String date ;
    @Excel(name = "阅读路径")
    private String path ;
    @Excel(name="PV")
    private long pv ;
}
