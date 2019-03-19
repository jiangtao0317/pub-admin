package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class ActivityDataPv {

    @Excel(name = "日期")
    private String date ;
    @Excel(name="活动")
    private String activity ;
    @Excel(name = "PV")
    private long pv ;
}
