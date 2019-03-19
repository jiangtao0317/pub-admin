package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class DataPv {

    @Excel(name = "日期")
    private String date ;
    @Excel(name = "PV")
    private long pv ;
}
