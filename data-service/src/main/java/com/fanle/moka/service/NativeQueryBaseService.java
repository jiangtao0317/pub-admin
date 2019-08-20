package com.fanle.moka.service;

import com.fanle.moka.config.CustomAliasToBeanResultTransformer;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
@Slf4j
public class NativeQueryBaseService {

    @PersistenceContext
    EntityManager entityManager ;

    public <S> List<S> nativeQuery(String sql,Class<S> cla ,Object... args){
        log.info("sql:{}",sql);
        Query query = entityManager.createNativeQuery(sql);
        int j = 0 ;
        for(int i = 0; i< args.length ; i++){
            if(args[i]!=null){
                query.setParameter(++j,args[i]);
            }

        }
        query.unwrap(NativeQuery.class).setResultTransformer(CustomAliasToBeanResultTransformer.aliasToBean(cla));
        List<S> list = query.getResultList();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list ;
    }
}
