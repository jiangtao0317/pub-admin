package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;
import lombok.ToString;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-05-14 15:27
 **/

@Data
@ToString
public class LoginUserVo {

    @Excel(name = "类型")
    private String type ;

    @Excel(name = "人数")
    private long uv ;
}
