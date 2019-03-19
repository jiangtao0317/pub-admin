package com.fanle.moka.constant;

import com.fanle.moka.constant.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum VersionEnum implements BaseEnum<Integer,String> {
    V_1(1,""),
    V_ALL(0,"all"),
    V_2(2,"");

    @Getter
    @Setter
    private Integer key ;

    @Getter
    @Setter
    private String Name ;


}
