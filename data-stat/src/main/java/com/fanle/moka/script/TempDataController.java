package com.fanle.moka.script;

import com.fanle.moka.service.ExportExcelService;
import com.fanle.moka.service.NativeQueryBaseService;
import com.fanle.moka.utils.DateUtil;
import com.fanle.moka.vo.LoginUserVo;
import com.fanle.moka.vo.UserBalanceVo;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-05-10 11:31
 **/

@Slf4j
@RestController
@RequestMapping("/user")
public class TempDataController {

    @Autowired
    NativeQueryBaseService nativeQueryBaseService ;

    @Autowired
    ExportExcelService exportExcelService ;

    @PersistenceContext
    EntityManager entityManager ;

    public static Set<String> beanCosts = Sets.newHashSet(new String[]{
            "C1-1-9-1","C1-1-9-2","C1-1-9-3","C1-1-9-4","C1-1-9-5","C1-1-9-6","C1-1-9-7","C1-1-9-8"
    });

    public static Set<String> incomeCosts = Sets.newHashSet(new String[]{
            "C2-1-9-1","C2-1-9-2","C2-1-9-3","C2-1-9-4","C2-1-1-2","C2-1-1-3","C2-1-1-4","C2-1-1-6","C2-1-1-8"
    });

    @RequestMapping("/money")
    public void money(HttpServletResponse res){
        List<UserBalanceVo> list = Lists.newArrayList() ;
        for(int i = 0 ; i < 100 ; i++) {
            String count = StringUtils.leftPad(String.valueOf(i), 2, '0');
            StringBuilder sql = new StringBuilder();
            sql.append("select case moneyType when 'C1' then '书豆' when 'C2' then '收入' when 'C3' then '书币' when 'C4' then '冻结收入' end type , sum(balance) income,count(distinct userid) uv from wenxue_cash.balance_")
                    .append(count).append(" where balance > 3000 and  moneyType = 'C2'  ");
            List<UserBalanceVo> list1 = entityManager.createNativeQuery(sql.toString()).unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(UserBalanceVo.class)).getResultList();
            if(!CollectionUtils.isEmpty(list1)){
                for(UserBalanceVo vo:list1){
                    UserBalanceVo result = contain(list,vo) ;
                    if(result!=null){
                        result.setIncome(result.getIncome().add(vo.getIncome()));
                        result.setUv(result.getUv()+vo.getUv());
                    }else{
                        list.add(vo);
                    }
                }
            }

        }
        exportExcelService.export("用户资产大于30.xlsx",res,null,list);
    }

    @RequestMapping("/money-all")
    public void moneyAll(HttpServletResponse res){
        List<UserBalanceVo> list = Lists.newArrayList() ;
        for(int i = 0 ; i < 100 ; i++) {
            String count = StringUtils.leftPad(String.valueOf(i), 2, '0');
            StringBuilder sql = new StringBuilder();
            sql.append("select case moneyType when 'C1' then '书豆' when 'C2' then '收入' when 'C3' then '书币' when 'C4' then '冻结收入' end type , sum(balance) income,count(distinct userid) uv from wenxue_cash.balance_")
                    .append(count).append(" where balance>0 and moneyType in ('C1','C2','C3','C4') group by moneyType ");
            List<UserBalanceVo> list1 = entityManager.createNativeQuery(sql.toString()).unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(UserBalanceVo.class)).getResultList();
            if(!CollectionUtils.isEmpty(list1)){
                for(UserBalanceVo vo:list1){
                    UserBalanceVo result = contain(list,vo) ;
                    if(result!=null){
                        result.setIncome(result.getIncome().add(vo.getIncome()));
                        result.setUv(result.getUv()+vo.getUv());
                    }else{
                        list.add(vo);
                    }
                }
            }

        }
        exportExcelService.export("用户资产.xlsx",res,null,list);
    }


    @RequestMapping("/login")
    public String login7(@RequestParam("day")int day, HttpServletResponse res){
        List<LoginUserVo> list = Lists.newArrayList() ;
        for(int i = 0 ; i < 100 ; i++) {
            String dateStr = DateUtil.currentString().substring(0,10);
            Date date = DateUtil.toDate(dateStr,DateUtil.DF_yyyy_MM_dd);

            Date end = DateUtil.add(date, Calendar.DAY_OF_MONTH,-day*7);
            String endStr = DateUtil.toString(end).substring(0,10);

            Date start =  DateUtil.add(date, Calendar.DAY_OF_MONTH,-(day+1)*7);
            String startStr = DateUtil.toString(start).substring(0,10);

            String count = StringUtils.leftPad(String.valueOf(i), 2, '0');
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT\n" +
                    "\ta.moneyType type,\n" +
                    "\tcount( distinct a.userid ) uv \n" +
                    "FROM\n" +
                    "\twenxue_cash.balance_"+count+" a,\n" +
                    "\twenxue_statistics.moka_stat_log_report b \n" +
                    "WHERE\n" +
                    "\ta.userid = b.userid \n" +
                    "\tAND b.date BETWEEN '"+startStr+"' \n" +
                    "\tAND '"+endStr+"' \n" +
                    "\tAND a.moneyType IN ( 'C1', 'C2', 'C3', 'C4' ) \n" +
                    "\tAND b.`event` in ('/miniAppsLogin','/phonecodelogin','/phoneBindLogin','/sessionlogin','/qqBindLogin','/qqlogin','/weiBoBindLogin','/weibologin','/weiXinBindLogin','/wxlogin','/yklogin')\n" +
                    "GROUP BY\n" +
                    "\ta.moneyType");
            List<LoginUserVo> list1 = entityManager.createNativeQuery(sql.toString()).unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(LoginUserVo.class)).getResultList();
            if(!CollectionUtils.isEmpty(list1)){
                for(LoginUserVo vo:list1){
                    LoginUserVo result = contain(list,vo) ;
                    if(result!=null){
                        result.setUv(result.getUv()+vo.getUv());
                    }else{
                        list.add(vo);
                    }
                }
            }
        }
        log.info("7日登录人数：{}",list);
       // exportExcelService.export("7日登录人数.xlsx",res,null,list);
        return list.toString() ;
    }



    private UserBalanceVo contain(List<UserBalanceVo> list , UserBalanceVo userBalanceVo){
        UserBalanceVo userBalanceVo1 = null ;
        for(int i = 0 ; i < list.size() ; i++){
            if(StringUtils.equalsIgnoreCase(list.get(i).getType(),userBalanceVo.getType())){
                userBalanceVo1 = list.get(i) ;
            }
        }
        return userBalanceVo1 ;
    }

    private LoginUserVo contain(List<LoginUserVo> list , LoginUserVo vo){
        LoginUserVo loginUserVo = null ;
        for(int i = 0 ; i < list.size() ; i++){
            if(StringUtils.equalsIgnoreCase(list.get(i).getType(),vo.getType())){
                loginUserVo = list.get(i) ;
            }
        }
        return loginUserVo ;
    }


}
