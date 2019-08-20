package com.fanle.moka.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "adminEntityManagerFactory",
        transactionManagerRef = "adminTransactionManager",
        basePackages = {"com.fanle.moka.respo.newadmin"}) //设置Repository所在位置

@PropertySource(value = "classpath:application-datasource.properties")
public class DataSourceNewAdminConfig {

    @Autowired
    private Environment env;

    @Bean(name = "adminDataSource")
    @Qualifier("adminDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.admin")
    public DataSource bookDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "adminEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("adminDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.fanle.moka.entity.newadmin.domain") // 【3】这里是实体类的包路径
                .persistenceUnit("com.fanle.moka.entity.newadmin.domain")
                .build();
    }


    @Bean(name = "adminTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("adminEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "adminJdbcTemplate")
    public JdbcTemplate bookJdbcTemplate(@Qualifier("adminDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
