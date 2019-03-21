package com.fanle.moka.service;

import com.fanle.moka.config.CustomAliasToBeanResultTransformer;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class NativeQueryBaseService {

    @PersistenceContext
    EntityManager entityManager ;

    public <S> List<S> nativeQuery(String sql,Class<S> cla ,Object... args){
        Query query = entityManager.createNativeQuery(sql);
        for(int i = 0 ; i< args.length ; i++){
            query.setParameter(i+1,args[i]);
        }
        query.unwrap(NativeQuery.class).setResultTransformer(CustomAliasToBeanResultTransformer.aliasToBean(cla));
        List<S> list = query.getResultList();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list ;
    }
}
