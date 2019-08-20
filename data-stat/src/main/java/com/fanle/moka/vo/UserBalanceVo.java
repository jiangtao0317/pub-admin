package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-05-10 11:39
 **/

@Data
public class UserBalanceVo {

    @Excel(name = "金额")
    private BigDecimal income = BigDecimal.ZERO ;

    @Excel(name = "类型")
    private String type ;

    @Excel(name = "人数")
    private long uv ;
}
