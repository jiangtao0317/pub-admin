package com.fanle.moka.service;

import java.util.List;


/**
 * 对导出excel的list集合进行格式转换
 * @param <S> 源集合
 * @param <T> 目标集合
 */
public interface ListContentFormatService<S,T> {

    List<T> format(List<S> sourceList, List<T> targetList) ;
}
