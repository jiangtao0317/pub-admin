package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class DataUv {

    @Excel(name = "日期")
    private String date ;
    @Excel(name = "UV")
    private long uv ;
}
