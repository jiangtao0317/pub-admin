package com.fanle.moka.config;

import org.hibernate.dialect.InnoDBStorageEngine;
import org.hibernate.dialect.MySQL57Dialect;
import org.hibernate.dialect.MySQLStorageEngine;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Component;

import java.sql.Types;

/**
 * @author jiangtao
 * @date 2018-11-14 10:20
 * @description entityManager 原生sql查询自动将BigInteger类型转为Long
 */

@Component
public class LocalMySQL5InnoDBDialect extends MySQL57Dialect {

    public LocalMySQL5InnoDBDialect() {
        super();
        registerHibernateType( Types.BIGINT, StandardBasicTypes.LONG.getName() );
    }

    @Override
    protected MySQLStorageEngine getDefaultMySQLStorageEngine() {
        return InnoDBStorageEngine.INSTANCE;
    }
}
