package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class MkStoreVo {

        @Excel(name = "日期")
        private String date ;
        @Excel(name="来源")
        private String source ;
        @Excel(name = "UV")
        private long uv ;

}
