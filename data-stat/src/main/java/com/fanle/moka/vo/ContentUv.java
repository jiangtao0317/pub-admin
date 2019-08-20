package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class ContentUv {

    @Excel(name = "日期")
    private String date ;
    @Excel(name = "uv")
    private long uv ;
}
