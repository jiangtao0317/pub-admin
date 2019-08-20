package com.fanle.moka.utils;

import com.fanle.moka.vo.TestDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-05-08 17:23
 **/

public class Demo {


    public static void main(String[] args) {
        List<TestDto> list = new ArrayList<>() ;
        TestDto dto = new TestDto() ;
        dto.setDate("2019-03-01");
        list.add(dto);

        TestDto dto1 = new TestDto() ;
        dto.setDate("2019-03-01");
        list.add(dto1);

        TestDto dto2 = new TestDto() ;
        dto.setDate("2019-03-01");
        list.add(dto2);

        TestDto dto3 = gen(list) ;
        dto3.setIds(12L);


    }

    public static TestDto gen(List<TestDto> dtos){
        return dtos.get(0);
    }
}
