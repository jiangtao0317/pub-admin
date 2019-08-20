package com.fanle.moka.controller;

import com.fanle.moka.respo.user.ShareRecordRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-04-22 19:42
 **/

@RestController
@RequestMapping("share")
public class ShareActiveController {

    @Autowired
    ShareRecordRespo shareRecordRespo ;

    public void active(@RequestParam("startDate")String startDate,
                       @RequestParam("endDate")String endDate,
                       @RequestParam("type")String type){


    }


}
