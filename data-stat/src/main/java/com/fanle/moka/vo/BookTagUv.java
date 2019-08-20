package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-06-22 10:40
 **/
@Data
public class BookTagUv {

    @Excel(name = "一级分类")
    private String typename1 ;
    @Excel(name = "二级分类")
    private String typename2 ;
    @Excel(name = "标签")
    private String tagname ;
    @Excel(name = "数量")
    private long uv ;

}
