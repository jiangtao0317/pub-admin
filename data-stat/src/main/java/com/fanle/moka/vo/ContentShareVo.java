package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-04-22 18:23
 **/

@Data
public class ContentShareVo {

    @Excel(name = "日期")
    private String date ;

    @Excel(name = "用户账号")
    private String userid ;
    @Excel(name = "PV")
    private long pv ;
    @Excel(name = "UV")
    private long uv ;
}
