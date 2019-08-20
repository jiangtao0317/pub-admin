package com.fanle.demo;

import com.fanle.moka.DataStatApplication;
import com.fanle.moka.respo.book.BookRespo;
import com.fanle.moka.respo.book.BookTagRepo;
import com.fanle.moka.service.TopBaseService;
import com.fanle.moka.utils.ExcelUtil;
import com.fanle.moka.vo.BookTagUv;
import com.fanle.moka.vo.BookVo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = DataStatApplication.class)
public class CoreApplicationTests {

    @PersistenceContext
    EntityManager entityManager ;

    @Autowired
    BookRespo bookRespo ;

    @Autowired
    TopBaseService baseService ;

    @Autowired
    BookTagRepo bookTagRepo ;

    @Value("${excel.out.path}")
    private String path ;


    @Test
    public void contextLoads() {
//        StringBuilder sql1 = new StringBuilder(" SELECT distinct bookid as aiBooks FROM wenxue_book.buybookorder_")
//                .append("00")
//                .append(" a, wenxue_statistics.moka_stat_day_book b where a.bookid = b.bookid and b.aiTodayReadSec > 0 ")
//                .append(" b.date = substr(a.orderTime,1,10) and a.source = 9 AND a.STATUS = 2 AND a.orderTime like ?1")
//                .append(" and platform in('android','ios') and coins > 0 ")
//                .append(" group by date order by date asc ");
//        Query query1 = entityManager.createNativeQuery(sql1.toString()).setParameter(1,"2019-04-18%");
//        List<Object> list1 = query1.getResultList() ;

//        String sql = "select sum(a.notifyCoins) from wenxue_book.buybookorder_00 a where a.bookid in ('10117','7606','5308') and substr(a.orderTime,1,10) = '2019-04-11' and a.source = 9 AND a.STATUS = 2  and a.platform in('android','ios') ";
//
//        StringBuilder sql2 = new StringBuilder("select sum(a.coins) from wenxue_book.buybookorder_")
//                .append("00").append(" a where a.bookid = 100267688 ");
//        Object obj = entityManager.createNativeQuery(sql.toString()).getSingleResult() ;
//        long sum = obj==null?0: ((BigDecimal)obj).longValue();

        try{
            List<String> tags = bookTagRepo.findAllTagName() ;
            Map<String, Long> map = Maps.newHashMap() ;
            List<BookVo> books = bookRespo.findAllBookVo();
            tags.forEach(x -> {
                if(!StringUtils.isEmpty(x)) {
                    books.forEach(y -> {
                        String key = x.concat("-").concat(y.getTypename());
                        if(y.getTags().contains(x)){
                            map.put(key,map.getOrDefault(key,0L)+1);
                        }
                    });
                }
            });
            List<BookTagUv> list = Lists.newArrayList() ;
            for(String key : map.keySet()){
                String[] names = key.split("-");
                BookTagUv bookTagUv = new BookTagUv();
                bookTagUv.setTagname(names[0]);
                bookTagUv.setTypename1(names[1]);
                bookTagUv.setTypename2(names[2]);
                bookTagUv.setUv(map.get(key));
                list.add(bookTagUv);
            }
            ExcelUtil excelUtil = new ExcelUtil();
            excelUtil.exportToFile(path+ LocalDate.now().toString()+"/booktaguv"+"/书籍分类标签数据.xlsx",list) ;
        }catch (Exception e){
            log.info("unknown exception:{}",e);
        }


    }

}
