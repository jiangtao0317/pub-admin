package com.fanle.moka.constant;

import com.fanle.moka.constant.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum ActivityEnum implements BaseEnum<String,String> {
    AC_REDBAG("ac_redbag","拆红包得现金"),
    AC_REDBAGNEW("ac_redbagnew","组队领现金"),
    AC_GIFTBOOK("ac_giftbook","免费送书读"),
    AC_GIFTBOOK2("ac_giftbook2","免费送书读"),
    AC_INVITENEW("ac_invitenew","邀新有礼"),
    AC_READINGPK("ac_readingpk2","阅读pk赛"),
    MKSTORE_REDBAG("mkstore_redbag","小程序拆红包"),
    MKSTORE_REDBAGNEW("mkstore_redbagnew","小程序-组队领现金"),
    AC_BEAN("ac_bean","瓜分书豆"),
    AC_UNLOCK("ac_unlock","邀好友解锁"),
    GAIN888("ac_invite888","狂赚888"),
    AC_GROUP("ac_group","组队活动"),
    AC_CHALLENGE("ac_challenge","阅读挑战赛"),
    AC_DOUBLE("ac_double","五月翻倍券"),
    AC_OPERATOR("ac_operator","书会运营官"),
    AC_TURNROUND("ac_turnround","摩卡翻翻乐"),
    AC_QIXI("ac_qixi","七夕配对"),
    AC_SINGLEDOG("ac_singledog","单身狗阅读挑战赛");

    @Setter
    @Getter
    private String key ;
    @Setter
    @Getter
    private String name ;
}
