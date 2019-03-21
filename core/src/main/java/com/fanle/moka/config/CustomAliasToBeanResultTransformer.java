package com.fanle.moka.config;

import org.hibernate.HibernateException;
import org.hibernate.property.access.internal.PropertyAccessStrategyBasicImpl;
import org.hibernate.property.access.internal.PropertyAccessStrategyChainedImpl;
import org.hibernate.property.access.internal.PropertyAccessStrategyFieldImpl;
import org.hibernate.property.access.internal.PropertyAccessStrategyMapImpl;
import org.hibernate.property.access.spi.PropertyAccessStrategy;
import org.hibernate.property.access.spi.Setter;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ResultTransformer;

import java.math.BigDecimal;
import java.util.Arrays;


/**
 * @author jiangtao
 * @description 此类用于nativequery 自动映射实体类时将sum(int) 等返回的bigdecimal类型数据转换为long
 */
public class CustomAliasToBeanResultTransformer extends AliasToBeanResultTransformer {
    private final Class resultClass;
    private boolean isInitialized;
    private String[] aliases;
    private Setter[] setters;

    private CustomAliasToBeanResultTransformer(Class resultClass) {
        super(resultClass);
        if (resultClass == null) {
            throw new IllegalArgumentException("resultClass cannot be null");
        } else {
            this.isInitialized = false;
            this.resultClass = resultClass;
        }
    }

    public static <T> ResultTransformer aliasToBean(Class<T> cla){
        CustomAliasToBeanResultTransformer customAliasToBeanResultTransformer = new CustomAliasToBeanResultTransformer(cla);
        return customAliasToBeanResultTransformer ;
    }

    private void initialize(String[] aliases) {
        PropertyAccessStrategyChainedImpl propertyAccessStrategy = new PropertyAccessStrategyChainedImpl(new PropertyAccessStrategy[]{PropertyAccessStrategyBasicImpl.INSTANCE, PropertyAccessStrategyFieldImpl.INSTANCE, PropertyAccessStrategyMapImpl.INSTANCE});
        this.aliases = new String[aliases.length];
        this.setters = new Setter[aliases.length];

        for(int i = 0; i < aliases.length; ++i) {
            String alias = aliases[i];
            if (alias != null) {
                this.aliases[i] = alias;
                this.setters[i] = propertyAccessStrategy.buildPropertyAccess(this.resultClass, alias).getSetter();
            }
        }

        this.isInitialized = true;
    }

    private void check(String[] aliases) {
        if (!Arrays.equals(aliases, this.aliases)) {
            throw new IllegalStateException("aliases are different from what is cached; aliases=" + Arrays.asList(aliases) + " cached=" + Arrays.asList(this.aliases));
        }
    }


    public Object transformTuple(Object[] tuple, String[] aliases) {
        try {
            if (!this.isInitialized) {
                this.initialize(aliases);
            } else {
                this.check(aliases);
            }

            Object result = this.resultClass.newInstance();

            for(int i = 0; i < aliases.length; ++i) {
                if (this.setters[i] != null) {
                    if (tuple[i].getClass().equals(BigDecimal.class)) {
                        this.setters[i].set(result, ((BigDecimal)tuple[i]).longValue(), null);
                    }else{
                        this.setters[i].set(result, tuple[i], null);
                    }

                }
            }

            return result;
        } catch (InstantiationException var5) {
            throw new HibernateException("Could not instantiate resultclass: " + this.resultClass.getName());
        } catch (IllegalAccessException var6) {
            throw new HibernateException("Could not instantiate resultclass: " + this.resultClass.getName());
        }
    }

}
