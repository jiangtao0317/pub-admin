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
        entityManagerFactoryRef = "bookEntityManagerFactory",
        transactionManagerRef = "bookTransactionManager",
        basePackages = {"com.fanle.moka.respo.book"}) //设置Repository所在位置

@PropertySource(value = "classpath:application-datasource.properties")
public class DataSourceBookConfig {

    @Autowired
    private Environment env;

    @Bean(name = "bookDataSource")
    @Qualifier("bookDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.book")
    public DataSource bookDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "bookEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("bookDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.fanle.moka.entity.book.domain") // 【3】这里是实体类的包路径
                .persistenceUnit("com.fanle.moka.entity.book.domain")
                .build();
    }


    @Bean(name = "bookTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("bookEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "bookJdbcTemplate")
    public JdbcTemplate bookJdbcTemplate(@Qualifier("bookDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
