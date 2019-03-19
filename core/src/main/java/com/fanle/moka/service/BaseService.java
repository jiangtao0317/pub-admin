package com.fanle.moka.service;

import com.fanle.moka.config.CustomAliasToBeanResultTransformer;
import com.fanle.moka.constant.base.BaseEnum;
import com.fanle.moka.utils.ExcelUtil;
import com.google.common.collect.Lists;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service
public class BaseService implements TopBaseService{

    @PersistenceContext
    EntityManager entityManager ;

    /**
     * 导出excel
     * @param filename 导出文件名
     * @param response
     * @param sql
     * @param cla 导出实体类映射对象
     * @param args 参数数组
     * @param <S,T>
     */
    @Override
    public <S,T> void export(String filename, ListContentFormatService<S, T> format , HttpServletResponse response, String sql, Class<?> cla, Object... args){
        Query query = entityManager.createNativeQuery(sql);
        for(int i = 0 ; i< args.length ; i++){
            query.setParameter(i+1,args[i]);
        }
        query.unwrap(NativeQuery.class).setResultTransformer(CustomAliasToBeanResultTransformer.aliasToBean(cla));
        List<S> list = query.getResultList();
        if (CollectionUtils.isEmpty(list)) {
            return ;
        }
        ExcelUtil excelUtil = new ExcelUtil();
        if(format!=null){
            List<T> targetList = Lists.newArrayList() ;
            targetList = format.format(list,targetList);
            excelUtil.export(filename, response, targetList);
        }else{
            excelUtil.export(filename, response, list);
        }
    }

    public static <T> String collectionToString(Collection<T> collection){
        String str = "(" ;
        Iterator<T> iterator = collection.iterator() ;
        while(iterator.hasNext()){
            T t = iterator.next();
            if(t instanceof Number){
                str += t + ",";
            }else
            if(t.getClass().equals(String.class)){
                str += "'"+t+"',";
            }else{
                str = "";
                break;
            }
        }
        if(!StringUtils.isEmpty(str)){
            str = str.substring(0,str.length()-1)+")";
        }
        return str ;
    }

    public static String getCaseWhen(String sql, BaseEnum[] baseEnums ){
        for(BaseEnum baseEnum:baseEnums){
            sql += " when '"+baseEnum.getKey()+"' then '"+baseEnum.getName() + "' ";
        }
        return sql ;
    }
}
