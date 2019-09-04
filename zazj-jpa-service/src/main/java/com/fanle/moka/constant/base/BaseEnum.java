package com.fanle.moka.constant.base;

import com.google.common.collect.Sets;

import java.util.Set;

public interface BaseEnum<I,N> extends TopBaseEnum<I,N>{

    /**
     * 通过第一个参数值（key）获取枚举类第二个参数值（name）
     * @param key
     * @param aEnums 枚举的所有值集合 通过values（）方法获取
     * @param <A>
     * @param <I>
     * @param <N>
     * @return
     */
    static <A extends BaseEnum<I,N>,I,N> N getName(I key, A[] aEnums){
        for(A readPathEnum:aEnums){
            if(key.equals(readPathEnum.getKey())){
                return readPathEnum.getName();
            }
        }
        return null ;
    }

    /**
     * 通过第二个参数值（name）获取枚举类第一个参数值（key）
     * @param name
     * @param aEnums 枚举的所有值集合 通过values（）方法获取
     * @param <A>
     * @param <I>
     * @param <N>
     * @return
     */
    static <A extends BaseEnum<I,N>,I,N> I getKey(N name, A[] aEnums){
        for(A readPathEnum:aEnums){
            if(name.equals(readPathEnum.getName())){
                return readPathEnum.getKey();
            }
        }
        return null ;
    }

    /**
     * 获取枚举类所有的key的集合 （第一个参数值的集合）
     * @param aEnums
     * @param <A>
     * @return
     */
    static <A extends BaseEnum<I,N>,I,N> Set<I> keyValues(A[] aEnums){
        Set<I> sets = Sets.newHashSet();
        for(A readPathEnum:aEnums){
            sets.add(readPathEnum.getKey());
        }
        return sets ;
    }

    /**
     * 获取枚举类所有的name的集合 （第二个参数值的集合）
     * @param aEnums
     * @param <A>
     * @return
     */
    static <A extends BaseEnum<I,N>,I,N> Set<N> nameValues(A[] aEnums){
        Set<N> sets = Sets.newHashSet();
        for(A readPathEnum:aEnums){
            sets.add(readPathEnum.getName());
        }
        return sets ;
    }

    static <I> Class<I> getKeyType(I key){
        return (Class<I>)key.getClass() ;
    }

    static <N> Class<N> getNameType(N name){
        return (Class<N>)name.getClass() ;
    }
}
