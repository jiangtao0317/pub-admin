//package com.fanle.moka.config;
//
//import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
//import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.Collection;
//
///**
// * @program: simple-application
// * @description:
// * @author: jiangtao
// * @create: 2019-05-14 11:13
// **/
//
//public class MyShardingConfig implements PreciseShardingAlgorithm<String>
//{
//    /**
//     * 精确分片算法
//     * 将user_id的值和5比较，如果小于等于5，数据对应的表为：USER_AUTH_1
//     * 将user_id的值和5比较，如果大于5，数据对应的表为：USER_AUTH_2
//     * @return
//     */
////    @Override
////    public String doSharding(Collection availableTargetNames, PreciseShardingValue<Long> shardingValue) {
////        if(availableTargetNames.contains("banlance")){
////            if(shardingValue.getColumnName().equalsIgnoreCase("USER_ID")){
////                String value = shardingValue.getValue();
////                Integer suffix = Integer.valueOf(value)%100 ;
////                int i = value.compareTo(5);
////                int suffix = -1;
////                if(i<=0){
////                    suffix = 1;
////                }else{
////                    suffix = 2;
////                }
////                String s = ("user_auth_" + suffix).toUpperCase();
////                return s;
////            }
////        }
////        return null;
////    }
//
//
//
//    @Override
//    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
//        if(collection.contains("banlance")){
//            if(preciseShardingValue.getColumnName().equalsIgnoreCase("userid")){
//                String value = preciseShardingValue.getValue();
//                Integer index = Integer.valueOf(value)%100 ;
//                String suffix = StringUtils.leftPad(index.toString(),2,'0');
//                String s = ("banlance_" + suffix);
//                return s;
//            }
//        }
//        return null;
//    }
//}
