package com.fanle.moka.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fanle.moka.entity.stat.domain.MokaStatChannelLogEntity;
import com.fanle.moka.respo.stat.MokaStatChannelLogRespo;
import com.fanle.moka.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: moka-newadmin
 * @description:
 * @author: jiangtao
 * @create: 2019-08-01 16:21
 **/

@Service
@Slf4j
public class H5PayMoneyRequestServiceImpl {

    @Autowired
    private MokaStatChannelLogRespo logRespo ;

    public void requestChannelTransfer(String url , Map<String,String> map){
        try {
            log.info("map:{}"+map.toString());
            String result = HttpUtil.get(url,map);
            map.put("result",result);
            JSONObject jsonObject = JSON.parseObject(map.get("result"));
            MokaStatChannelLogEntity logEntity = logRespo.findFirstByDateAndCidAndPlatform(map.get("date"),map.get("cid"),map.get("platform"));
            if(logEntity==null){
                return;
            }
            if((Integer)jsonObject.get("code")==1){
               if("adv".equals(map.get("type"))){
                   logEntity.setAdsenseOrderId(jsonObject.get("orderid").toString());
                   logEntity.setAdsenseOrderStatus((byte)1);
               }
                if("pay".equals(map.get("type"))){
                    logEntity.setPayOrderId(jsonObject.get("orderid").toString());
                    logEntity.setPayOrderStatus((byte)1);
                }
            }else{
                if("adv".equals(map.get("type"))){
                    logEntity.setAdsenseOrderStatus((byte)2);
                }
                if("pay".equals(map.get("type"))) {
                    logEntity.setPayOrderStatus((byte) 2);
                }
            }
            logRespo.saveAndFlush(logEntity);
        } catch (Exception e) {
            log.info("Exception:{}",e);
        }
    }

}
