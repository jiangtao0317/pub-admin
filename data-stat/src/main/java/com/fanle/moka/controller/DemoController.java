package com.fanle.moka.controller;

import com.fanle.moka.respo.book.BookRespo;
import com.fanle.moka.respo.stat.MokaStatLogReportRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-04-22 18:38
 **/
@RestController
public class DemoController {

    @Autowired
    private BookRespo bookRespo ;

    @Autowired
    private MokaStatLogReportRespo mokaStatLogReportRespo ;

    @PersistenceContext
    EntityManager entityManager ;

    @RequestMapping("/demo")
    public void demo(){

    }
}
