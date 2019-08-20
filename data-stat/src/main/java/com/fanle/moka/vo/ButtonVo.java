package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class ButtonVo {

    @Excel(name = "日期")
    private String date ;
    @Excel(name = "PV")
    private long pv ;
    @Excel(name = "UV")
    private long uv ;
}
