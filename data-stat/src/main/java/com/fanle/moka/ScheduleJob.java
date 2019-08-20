package com.fanle.moka;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: moka-newadmin
 * @description:
 * @author: jiangtao
 * @create: 2019-08-01 17:17
 **/

@Component
public class ScheduleJob {

//    @Autowired
//    H5PayMoneyRequestServiceImpl requestService ;
//
//    @Autowired
//    MokaStatChannelLogRespo channelLogRespo ;

//    @Value("${h5.distribute.url}")
//    private String distributeUrl ;
//
//    @Scheduled(fixedDelay = 2*60*60*1000)
//    @Transactional
//    public void H5ChannelRate(){
//        LocalDate localDate = LocalDate.now();
//        LocalDate statDate = localDate.plusDays(-1);
//        List<MokaStatChannelLogEntity> adSenseList = channelLogRespo.findAllByDateAndPlatformAndAdsenseOrderStatusAndH5AdsenseRateMoneyGreaterThan(statDate.toString(), "h5",(byte)2,0);
//        List<MokaStatChannelLogEntity> payList = channelLogRespo.findAllByDateAndPlatformAndPayOrderStatusAndH5RateMoneyGreaterThan(statDate.toString(), "h5",(byte)2,0);
//        final Map<String,String> adsenseMap = new HashMap<>();
//        final Map<String,String> payMap = new HashMap<>();
//        adSenseList.forEach(logEntity -> {
//            genMapParam(adsenseMap,logEntity.getCid(),logEntity.getPlatform(),logEntity.getDate(),"adv");
//            requestService.requestChannelTransfer(distributeUrl,adsenseMap);
//        });
//
//        payList.forEach(logEntity -> {
//            genMapParam(payMap,logEntity.getCid(),logEntity.getPlatform(),logEntity.getDate(),"pay");
//            requestService.requestChannelTransfer(distributeUrl,payMap);
//        });
//
//    }

    public static void genMapParam(Map<String,String> map ,String cid,String platform,String date,String type){
        if(map==null){
            map = Maps.newHashMap() ;
        }
        map.put("cid",cid);
        map.put("platform",platform);
        map.put("date",date);
        map.put("type",type);
    }


}
