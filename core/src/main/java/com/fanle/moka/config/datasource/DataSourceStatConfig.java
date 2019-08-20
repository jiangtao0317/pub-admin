package com.fanle.moka.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
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
        entityManagerFactoryRef = "statEntityManagerFactory",
        transactionManagerRef = "statTransactionManager",
        basePackages = {"com.fanle.moka.respo.stat"}) //设置Repository所在位置
@PropertySource(value = "classpath:application-datasource.properties")
public class DataSourceStatConfig {


    @Bean(name = "statDataSource")
    @Primary
    @Qualifier("statDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.stat")
    public DataSource statDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    @Primary
    @Bean(name = "statEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("statDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.fanle.moka.entity.stat.domain") // 【3】这里是实体类的包路径
                .persistenceUnit("com.fanle.moka.entity.stat.domain")
                .build();
    }

    @Primary
    @Bean(name = "statTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("statEntityManagerFactory") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "statJdbcTemplate")
    public JdbcTemplate bookJdbcTemplate(@Qualifier("statDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
