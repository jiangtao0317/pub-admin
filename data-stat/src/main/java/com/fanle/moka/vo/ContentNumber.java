package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class ContentNumber {

    @Excel(name = "日期")
    private String date ;
    @Excel(name = "数量")
    private long number ;
}
