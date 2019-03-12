package com.fanle.moka.controller;


import com.fanle.moka.respo.BookRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping("/demo")
public class MainController {

    @Autowired
    BookRespo bookRespo ;

    @PersistenceContext
    EntityManager entityManager ;

    @RequestMapping("/hello")
    public String demo(){
        return "hello" ;
    }
}
