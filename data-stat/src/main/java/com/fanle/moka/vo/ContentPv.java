package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class ContentPv {

    @Excel(name = "日期")
    private String date ;
    @Excel(name = "pv")
    private long pv ;
}
