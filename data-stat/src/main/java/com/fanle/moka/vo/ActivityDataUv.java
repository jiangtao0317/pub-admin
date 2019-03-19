package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class ActivityDataUv {

    @Excel(name = "日期")
    private String date ;
    @Excel(name="活动")
    private String activity ;
    @Excel(name = "UV")
    private long uv ;
}
