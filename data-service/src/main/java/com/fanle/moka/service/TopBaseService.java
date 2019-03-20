package com.fanle.moka.service;

import javax.servlet.http.HttpServletResponse;

public interface TopBaseService {

    <S,T> void export(String filename, ListContentFormatService<S, T> format, HttpServletResponse response, String sql, Class<?> cla, Object... args) ;

}
