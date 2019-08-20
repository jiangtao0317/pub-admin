package com.fanle.moka.script;

import com.fanle.moka.ScheduleJob;
import com.fanle.moka.entity.book.domain.BookEntity;
import com.fanle.moka.entity.stat.domain.MokaStatChannelLogEntity;
import com.fanle.moka.respo.book.BookRespo;
import com.fanle.moka.respo.book.BookTagRepo;
import com.fanle.moka.respo.stat.MokaStatChannelLogRespo;
import com.fanle.moka.service.*;
import com.fanle.moka.utils.ExcelUtil;
import com.fanle.moka.utils.StringTransferUtil;
import com.fanle.moka.vo.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/moka")
public class ScriptController {

    @Autowired
    BookRespo bookRespo ;

    @Autowired
    TopBaseService baseService ;

    @Autowired
    BookTagRepo bookTagRepo ;

    //    @Autowired
//    BookRespo bookRespo ;
    @Autowired
    NativeQueryBaseService nativeQueryBaseService ;

    @Autowired
    ExportExcelService exportExcelService ;

    @PersistenceContext
    EntityManager entityManager ;

    @Value("${excel.out.path}")
    private String path ;

    @Autowired
    private MokaStatChannelLogRespo channelLogRespo ;

    @Autowired
    H5PayMoneyRequestServiceImpl requestService ;



    @RequestMapping("/h5/transfer")
    public String transfer(){
        List<MokaStatChannelLogEntity> adSenseList = channelLogRespo.findAllByPlatformAndAdsenseOrderStatusNotAndH5AdsenseRateMoneyGreaterThan( "h5",(byte)1,0);
        log.info("adsenseList:{}",adSenseList.size());
        List<MokaStatChannelLogEntity> payList = channelLogRespo.findAllByPlatformAndPayOrderStatusNotAndH5RateMoneyGreaterThan("h5",(byte)1,0);
        log.info("payList:{}",payList.size());
        final Map<String,String> adsenseMap = new HashMap<>();
        final Map<String,String> payMap = new HashMap<>();
        adSenseList.forEach(logEntity -> {
            ScheduleJob.genMapParam(adsenseMap,logEntity.getCid(),logEntity.getPlatform(),logEntity.getDate(),"adv");
            requestService.requestChannelTransfer("http://192.168.11.29:1101/addfenfacash",adsenseMap);
        });

        payList.forEach(logEntity -> {
            ScheduleJob.genMapParam(payMap,logEntity.getCid(),logEntity.getPlatform(),logEntity.getDate(),"pay");
            requestService.requestChannelTransfer("http://192.168.11.29:1101/addfenfacash",payMap);
        });
        return "ok";
    }

    @RequestMapping("/h5/transfer2")
    public String transfer2(){
        List<MokaStatChannelLogEntity> adSenseList = channelLogRespo.findAllByPlatformAndAdsenseOrderStatusAndH5AdsenseRateMoneyGreaterThan( "h5",(byte)2,0);
        log.info("adsenseList:{}",adSenseList.size());
        List<MokaStatChannelLogEntity> payList = channelLogRespo.findAllByPlatformAndPayOrderStatusAndH5RateMoneyGreaterThan("h5",(byte)2,0);
        log.info("payList:{}",payList.size());
        final Map<String,String> adsenseMap = new HashMap<>();
        final Map<String,String> payMap = new HashMap<>();
        adSenseList.forEach(logEntity -> {
            ScheduleJob.genMapParam(adsenseMap,logEntity.getCid(),logEntity.getPlatform(),logEntity.getDate(),"adv");
            requestService.requestChannelTransfer("http://192.168.11.29:1101/addfenfacash",adsenseMap);
        });

        payList.forEach(logEntity -> {
            ScheduleJob.genMapParam(payMap,logEntity.getCid(),logEntity.getPlatform(),logEntity.getDate(),"pay");
            requestService.requestChannelTransfer("http://192.168.11.29:1101/addfenfacash",payMap);
        });
        return "ok";
    }

    @RequestMapping("export/booktaguv")
    public String queryTags(HttpServletResponse response){
        try{
            List<String> tags = bookTagRepo.findAllTagName() ;
            Map<String, Long> map = Maps.newHashMap() ;
            List<BookVo> books = bookRespo.findAllBookVo();
            tags.forEach(x -> {
                books.forEach(y -> {
                    String key = x.concat("--").concat(y.getTypename().replaceAll("-","--"));
                    if(y.getTags().contains(x)){
                        map.put(key,map.getOrDefault(key,0L)+1);
                    }
                });
            });
            List<BookTagUv> list = Lists.newArrayList() ;
            for(String key : map.keySet()){
                String[] names = key.split("--");
                BookTagUv bookTagUv = new BookTagUv();
                bookTagUv.setTagname(names[0]);
                bookTagUv.setTypename1(names[1]);
                bookTagUv.setTypename2(names[2]);
                bookTagUv.setUv(map.get(key));
                list.add(bookTagUv);
            }
            ExcelUtil excelUtil = new ExcelUtil();
            excelUtil.exportToFile(path+LocalDate.now().toString()+"/booktaguv"+"/书籍分类标签数据.xlsx",list);
            return "ok";
        }catch (Exception e){
            log.info("unknown exception:{}",e);
        }
        return "error" ;
    }

    @RequestMapping("/updateTotalChapter/bookid")
    public String updateBoonTotalChapterByBookid(@RequestParam("password")String password){
        if(!password.equals("moka1234")){
            return "fail";
        }
        List<BookEntity> books = bookRespo.findAllByBookid("4090");
        for(BookEntity book:books){
            log.info("bookid:{}-------bookname:{}",book.getBookid(),book.getBookname());
            Integer index = Integer.valueOf(book.getBookid())%100 ;
            try{
                Object object =  entityManager.createNativeQuery("select count(*) from wenxue_book.bookchapter_"+
                        StringUtils.leftPad(index.toString(),2,"0")+" where status = 2 and bookid = ?")
                        .setParameter(1,book.getBookid()).getSingleResult();
                book.setTotalchapter(object==null?0:Integer.valueOf(object.toString()));
            }catch (Exception e){
                log.info("query total chapter exception:============================={}",e);
            }
            bookRespo.saveAll(books);
        }

        return "success";
    }

    @RequestMapping("/updateTotalChapter")
    public String updateBoonTotalChapterBy(@RequestParam("password")String password){
        if(!password.equals("moka1234")){
            return "fail";
        }
        Set<String> sets = Sets.newHashSet() ;
        sets.add("12");
        sets.add("1");
        List<BookEntity> books = bookRespo.findAllBySourceIn(sets);
        for(BookEntity book:books){
            log.info("bookid:{}-------bookname:{}",book.getBookid(),book.getBookname());
            Integer index = Integer.valueOf(book.getBookid())%100 ;
            try{
                Object object =  entityManager.createNativeQuery("select count(*) from wenxue_book.bookchapter_"+
                        StringUtils.leftPad(index.toString(),2,"0")+" where status = 2 and bookid = ?")
                        .setParameter(1,book.getBookid()).getSingleResult();
                book.setTotalchapter(object==null?0:Integer.valueOf(object.toString()));
            }catch (Exception e){
                log.info("query total chapter exception:============================={}",e);
            }
            bookRespo.saveAll(books);

        }

        return "success";
    }

    @RequestMapping("/updateBookWords")
    public String updateBookWords(@RequestParam("password")String password){
        if(!password.equals("moka1234")){
            return "fail";
        }
        Set<String> sets = Sets.newHashSet() ;
        sets.add("12");
        sets.add("1");
        List<BookEntity> books = bookRespo.findAllBySourceIn(sets);
        for(BookEntity book:books){
            log.info("bookid:{}-------bookname:{}",book.getBookid(),book.getBookname());
            Integer index = Integer.valueOf(book.getBookid())%100 ;
            try{
                Object object =  entityManager.createNativeQuery("select sum(totalwords) from wenxue_book.bookchapter_"+
                        StringUtils.leftPad(index.toString(),2,"0")+" where status = 2 and bookid = ?")
                        .setParameter(1,book.getBookid()).getSingleResult();
                book.setTotalwords(object==null?0:Integer.valueOf(object.toString()));
            }catch (Exception e){
                log.info("query total words exception:============================={}",e);
            }
            bookRespo.saveAll(books);
        }

        return "success";
    }


    @RequestMapping("/platform/read")
    public void platformRead(@RequestParam("startDate")String startDate, @RequestParam("endDate")String endDate, HttpServletResponse response){
        StringBuilder sql1 = new StringBuilder();
        sql1.append(" select distinct a.bookid from wenxue_book.book a , wenxue_book.system_authorize_log b where a.originalBookId = b.original_book_id and b.pay_time between '"+startDate+"' and '"+endDate+"' ");
        Query query1 = entityManager.createNativeQuery(sql1.toString());
        List<Object> list1 = query1.getResultList() ;
        if(!CollectionUtils.isEmpty(list1)){
            List<String> list = list1.stream().map(x -> x.toString()).collect(Collectors.toList());
            StringBuilder sql2 = new StringBuilder("select distinct userid,ext0 as bookid from wenxue_statistics.moka_stat_log_report")
                    .append("  where `event` = '/addreadprogress' and datetime between '"+startDate+"' and '"+endDate+"' ")
                    .append(" and ext0 in "+BaseService.collectionToString(list)+" and ext1 > 0 ");
            Query query2 = entityManager.createNativeQuery(sql2.toString()).unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(UserReadBookVo.class));
            List<UserReadBookVo> result = query2.getResultList();
            Map<String,Set<String>> map = Maps.newHashMap() ;
            for(UserReadBookVo userReadBookVo:result){
                Set<String> sets = map.get(userReadBookVo.getUserid());
                if(sets==null){
                    map.put(userReadBookVo.getUserid(),Sets.newHashSet());
                }
                map.get(userReadBookVo.getUserid()).add(userReadBookVo.getBookid());
            }
            log.info("map:{}",map);
            for(String userid:map.keySet()){
                log.info("userid==={},阅读平台充值阅文书籍数量=={}",userid,map.get(userid).size());
            }
            exportExcelService.export("用户读书情况.xlsx",response,null,result);
        }

    }

    @RequestMapping("/user/read")
    public void userRead(@RequestParam("startDate")String startDate, @RequestParam("endDate")String endDate, HttpServletResponse response){
        StringBuilder sql1 = new StringBuilder();
        sql1.append(" select distinct a.bookid from wenxue_book.buybookorder b where b.`status` = 2 and b.coins > 0 and b.source = '9' and b.orderTime between '"+startDate+"' and '"+endDate+"' ");
        Query query1 = entityManager.createNativeQuery(sql1.toString());
        List<Object> list1 = query1.getResultList() ;
        if(!CollectionUtils.isEmpty(list1)){
            List<String> list = list1.stream().map(x -> x.toString()).collect(Collectors.toList());
            StringBuilder sql2 = new StringBuilder("select distinct userid,ext0 as bookid from wenxue_statistics.moka_stat_log_report")
                    .append("  where `event` = '/addreadprogress' and datetime between '"+startDate+"' and '"+endDate+"' ")
                    .append(" and ext0 in "+BaseService.collectionToString(list)+" and ext1 > 0 ");
            Query query2 = entityManager.createNativeQuery(sql2.toString()).unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(UserReadBookVo.class));
            List<UserReadBookVo> result = query2.getResultList();
            Map<String,Set<String>> map = Maps.newHashMap() ;
            for(UserReadBookVo userReadBookVo:result){
                Set<String> sets = map.get(userReadBookVo.getUserid());
                if(sets==null){
                    map.put(userReadBookVo.getUserid(),Sets.newHashSet());
                }
                map.get(userReadBookVo.getUserid()).add(userReadBookVo.getBookid());
            }
            log.info("map:{}",map);
            for(String userid:map.keySet()){
                log.info("userid==={},阅读用户充值阅文书籍数量=={}",userid,map.get(userid).size());
            }
            exportExcelService.export("用户读书情况.xlsx",response,null,result);
        }

    }

    @RequestMapping("/yuewen-money")
    public String yuewen(@RequestParam("startDate")String startDate, @RequestParam("endDate")String endDate, HttpServletResponse response){
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate = StringTransferUtil.endDateStr(endDate);
        List<TestDto> list = Lists.newArrayList() ;
        for(int i = 0 ; i < 100 ; i++){
            String count = StringUtils.leftPad(String.valueOf(i),2,'0');
            StringBuilder sql1 = new StringBuilder();
            sql1.append(" SELECT substr(orderTime,1,10) date,sum(notifyCoins) as money,count(distinct userid) as ids , count(distinct bookid) as bookNum FROM wenxue_book.buybookorder_")
                    .append(count)
                    .append(" where source = 9 AND STATUS = 2 AND orderTime BETWEEN '"+startDate+"' ")
                    .append(" and '"+endDate+"' and platform in('android','ios') and coins > 0 ")
                    .append(" group by date order by date asc ");
            Query query1 = entityManager.createNativeQuery(sql1.toString());
            query1.unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(TestDto.class));
            List<TestDto> list1 = query1.getResultList();

            for(TestDto dto1 :list1){
                TestDto result = contains(list,dto1) ;
                if(result!=null){
                    result.setMoney(result.getMoney().add(dto1.getMoney()));
                    result.setIds(result.getIds()+dto1.getIds());
                    result.setBookNum(result.getBookNum()+dto1.getBookNum());
                }else{
                   list.add(dto1);
                }
            }

        }
        list.sort(Comparator.comparing(TestDto::getDate));
        exportExcelService.export("a.xlsx",response,null,list);

        return "";
    }

    @RequestMapping("/yuewen-book")
    public String yuewenDetail(@RequestParam("startDate")String startDate, @RequestParam("endDate")String endDate, HttpServletResponse response){
//        startDate = StringTransferUtil.startDateStr(startDate);
//        endDate = StringTransferUtil.endDateStr(endDate);
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<RecommendVo> list = Lists.newArrayList() ;
        while (!start.isAfter(end)) {
            Set<String> aibookids = Sets.newHashSet() ;
            Set<String> manualbookids = Sets.newHashSet() ;
            Set<String> normalbookids = Sets.newHashSet() ;
            long aiMoney = 0 ;
            long manualMoney = 0 ;
            long normalMoney = 0 ;
            StringBuilder sql1 = new StringBuilder();
            sql1.append(" SELECT distinct a.bookid  FROM wenxue_book.buybookorder")
                    .append(" a, wenxue_statistics.moka_stat_day_book b where a.bookid = b.bookid and b.aiTodayReadSec > 0 ")
                    .append(" and b.date = substr(a.orderTime,1,10) and a.source = 9 AND a.STATUS = 2 AND substr(a.orderTime,1,10) = '"+start.format(DateTimeFormatter.ISO_LOCAL_DATE)+"'")
                    .append(" and a.platform in('android','ios') ");
            Query query1 = entityManager.createNativeQuery(sql1.toString());
            List<Object> list1 = query1.getResultList() ;
            if(list1!=null){
                List<String> aiBookids1 = list1.stream().map(x -> x.toString()).collect(Collectors.toList()) ;

                if(!CollectionUtils.isEmpty(aiBookids1)){
                    StringBuilder sql2 = new StringBuilder("select sum(a.notifyCoins) from wenxue_book.buybookorder")
                            .append(" a where a.bookid in "+BaseService.collectionToString(aiBookids1)+" and substr(a.orderTime,1,10) = '"+start.format(DateTimeFormatter.ISO_LOCAL_DATE)+"' and a.source = 9 AND a.STATUS = 2 ")
                            .append(" and a.platform in('android','ios') ") ;

                    Query query2 = entityManager.createNativeQuery(sql2.toString());
                    Object obj = query2.getSingleResult() ;
                    log.info("obj ========= {}",obj);
                    if(obj!=null && !obj.equals(0)){
                        aiMoney  =((BigDecimal)obj).longValue()+aiMoney;
                    }
                    aibookids.addAll(aiBookids1);
                }
            }
            entityManager.clear();
            log.info("first end::::::aimoney = {}",aiMoney);
            StringBuilder sql3 = new StringBuilder();
            sql3.append(" SELECT distinct a.bookid FROM wenxue_book.buybookorder")
                    .append(" a, wenxue_statistics.moka_stat_day_book b where a.bookid = b.bookid and b.manualTodayReadSec > 0 ")
                    .append(" and b.date = substr(a.orderTime,1,10) and a.source = 9 AND a.STATUS = 2 AND substr(a.orderTime,1,10) = '"+start.format(DateTimeFormatter.ISO_LOCAL_DATE)+"' ")
                    .append(" and a.platform in('android','ios') ");
            Query query3 = entityManager.createNativeQuery(sql3.toString());
            List<Object> list3 = query3.getResultList() ;
            if(list3!=null){
                List<String> manualBookids1 = list3.stream().map(x -> x.toString()).collect(Collectors.toList()) ;

                if(!CollectionUtils.isEmpty(manualBookids1)){
                    StringBuilder sql4 = new StringBuilder("select sum(a.notifyCoins) from wenxue_book.buybookorder")
                            .append(" a where a.bookid in "+BaseService.collectionToString(manualBookids1)+" and substr(a.orderTime,1,10) = '"+start.format(DateTimeFormatter.ISO_LOCAL_DATE)+"' and a.source = 9 AND a.STATUS = 2 ")
                            .append(" and a.platform in('android','ios') ") ;

                    Query query4 = entityManager.createNativeQuery(sql4.toString());
                    Object obj1 = query4.getSingleResult() ;
                    if(obj1!=null && !obj1.equals(0)){
                        manualMoney  =((BigDecimal)obj1).longValue()+manualMoney;
                    }
                    manualbookids.addAll(manualBookids1);
                }
            }
            entityManager.clear();
            log.info("second end::::::aimoney = {}",manualMoney);
            StringBuilder sql5 = new StringBuilder();
            sql5.append(" SELECT distinct a.bookid  FROM wenxue_book.buybookorder")
                    .append(" a, wenxue_statistics.moka_stat_day_book b where a.bookid = b.bookid and b.normalTodayReadSec > 0 ")
                    .append(" and b.date = substr(a.orderTime,1,10) and a.source = 9 AND a.STATUS = 2 AND substr(a.orderTime,1,10) = '"+start.format(DateTimeFormatter.ISO_LOCAL_DATE)+"' ")
                    .append(" and a.platform in('android','ios') ");
            Query query5 = entityManager.createNativeQuery(sql5.toString());
            List<Object> list5 = query5.getResultList() ;
            if(list5!=null){
                List<String> normalBookids = list5.stream().map(x -> x.toString()).collect(Collectors.toList()) ;

                if(!CollectionUtils.isEmpty(normalBookids)){
                    StringBuilder sql6 = new StringBuilder("select sum(a.notifyCoins) from wenxue_book.buybookorder")
                            .append(" a where a.bookid in "+BaseService.collectionToString(normalBookids)+" and substr(a.orderTime,1,10) = '"+start.format(DateTimeFormatter.ISO_LOCAL_DATE)+"' and a.source = 9 AND a.STATUS = 2 ")
                            .append(" and a.platform in('android','ios') ") ;

                    Query query6 = entityManager.createNativeQuery(sql6.toString());
                    Object obj2 = query6.getSingleResult() ;
                    if(obj2!=null && !obj2.equals(0)){
                        normalMoney  =((BigDecimal)obj2).longValue()+normalMoney;
                    }
                    normalbookids.addAll(normalBookids);
                }
            }
            RecommendVo recommendVo = new RecommendVo() ;
            recommendVo.setDate(start.format(DateTimeFormatter.ISO_LOCAL_DATE));
            recommendVo.setAiBooks(aibookids.size());
            recommendVo.setManualBooks(manualbookids.size());
            recommendVo.setNormalBooks(normalbookids.size());

            recommendVo.setAiMoney(aiMoney);
            recommendVo.setManualMoney(manualMoney);
            recommendVo.setNormalMoney(normalMoney);
            list.add(recommendVo);
            start = start.plusDays(1);
        }
        log.info("list::::{}",list);
        exportExcelService.export("机推数据.xlsx",response,null,list);
        return "";
    }




//        int androidMoney = 0;
//        int iosMoney = 0;
//        int androidIds = 0;
//        int iosIds = 0;
//        for(int i = 0;i<100;i++){
//            String count = StringUtils.leftPad(String.valueOf(i),2,'0');
//            StringBuilder sql1 = new StringBuilder();
//            sql1.append(" SELECT sum(notifyCoins) as money,count(distinct userid) as ids FROM wenxue_book.buybookorder_")
//                    .append(count)
//                    .append(" where source = 9 AND STATUS = 2 AND orderTime BETWEEN '"+startDate+"' ")
//                    .append(" and '"+endDate+"' and platform = 'android' ");
//            Query query1 = entityManager.createNativeQuery(sql1.toString());
//            query1.unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(TestDto.class));
//            List<TestDto> list1 = query1.getResultList();
//            if(CollectionUtils.isNotEmpty(list1)) {
//                int amount1 = list1.get(0).getMoney()==null?0:list1.get(0).getMoney().intValue();
//                int androidId = list1.get(0).getIds()==null?0:list1.get(0).getIds().intValue();
//                androidMoney += amount1;
//                androidIds += androidId;
//            }
//
//
//            StringBuilder sql2 = new StringBuilder();
//            sql2.append(" SELECT sum(notifyCoins) as money,count(distinct userid) as ids FROM wenxue_book.buybookorder_")
//                    .append(count)
//                    .append(" where source = 9 AND STATUS = 2 AND orderTime BETWEEN '\"+startDate+\"' ")
//                    .append(" and '\"+endDate+\"' and platform = 'ios' ");
//            Query query2 = entityManager.createNativeQuery(sql2.toString());
//            query2.unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(TestDto.class));
//            List<TestDto> list2 = query2.getResultList();
//            if(CollectionUtils.isNotEmpty(list2)) {
//                int amount2 = list2.get(0).getMoney()==null?0:list2.get(0).getMoney().intValue();
//                int iosId = list2.get(0).getIds()==null?0:list2.get(0).getIds().intValue();
//                iosMoney += amount2;
//                iosIds += iosId;
//            }
//        }
//        log.info("androidMoney阅文数据:"+androidMoney);
//        log.info("iosMoney阅文数据:"+iosMoney);
//        log.info("android用户阅文数据:"+androidIds);
//        log.info("ios用户阅文数据:"+iosIds);


    private TestDto contains(List<TestDto> list ,TestDto dto){
        TestDto result = null ;
        for(int i = 0 ; i < list.size() ; i++){
            if(StringUtils.equalsIgnoreCase(list.get(i).getDate(),dto.getDate())){
                result =  list.get(i);
            }
        }
        return  result  ;
    }
}
