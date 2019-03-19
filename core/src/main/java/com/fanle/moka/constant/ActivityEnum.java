package com.fanle.moka.constant;

import com.fanle.moka.constant.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum ActivityEnum implements BaseEnum<String,String> {
    AC_REDBAG("ac_redbag","拆红包得现金"),
    AC_GIFTBOOK("ac_giftbook","免费送书读"),
    AC_INVITENEW("ac_invitenew","邀新有礼"),
    MKSTORE_REDBAG("mkstore_redbag","小程序拆红包"),
    GAIN888("ac_invite888","狂赚888");

    @Setter
    @Getter
    private String key ;
    @Setter
    @Getter
    private String name ;
}
