package com.fanle.moka.constant;

import com.fanle.moka.constant.base.BaseEnum;

import java.util.Set;

public class DataBaseConstant {

    public static final String WENXUE_STAT = "wenxue_statistics" ;

    public static void main(String[] args) {
        Set keys = BaseEnum.keyValues(ReadPathEnum.values());
//        Set names = ReadPathEnum.clubChatEnterReader.nameValues(ReadPathEnum.values());
        keys.forEach(x -> System.out.println(x));
//        names.forEach(x -> System.out.println(x));

        String name = BaseEnum.getName("clubReadTogetherEnterReader",ReadPathEnum.values()) ;
        System.out.println(name);
    }
}
