package com.fanle.moka.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef = "userTransactionManager",
        basePackages = {"com.fanle.moka.respo.user"}) //设置Repository所在位置
public class DataSourceUserConfig {
    @Autowired
    private Environment env;

    @Bean(name = "userDataSource")
    @Qualifier("userkDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user")
    public DataSource userDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("userDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.fanle.moka.entity.user.domain") // 【3】这里是实体类的包路径
                .persistenceUnit("com.fanle.moka.entity.user.domain")
                .build();
    }

    @Bean(name = "userTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("userEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "userJdbcTemplate")
    public JdbcTemplate userJdbcTemplate(@Qualifier("userDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
