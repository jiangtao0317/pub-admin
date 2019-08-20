//package com.fanle.moka.config.datasource;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "moguEntityManagerFactory",
//        transactionManagerRef = "moguTransactionManager",
//        basePackages = {"com.fanle.moka.mogu.respo"}) //设置Repository所在位置
//@PropertySource(value = "classpath:application-datasource.properties")
//public class DataSourceMoguConfig {
//
//    @Bean(name = "moguDataSource")
//    @Qualifier("moguDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.mogu")
//    public DataSource moguDataSource() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
////    @Bean(name = "moguDataSource")
////    @Qualifier("moguDataSource")
////    public DataSource moguDataSource() throws SQLException {
////        return DruidDataSourceBuilder.create().build();
////    }
//
//
//    @Bean(name = "moguEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("moguDataSource") DataSource dataSource
//    ) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.fanle.moka.entity.mogu.domain") // 【3】这里是实体类的包路径
//                .persistenceUnit("com.fanle.moka.entity.book.domain")
//                .build();
//    }
//
//
//    @Bean(name = "moguTransactionManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("moguEntityManagerFactory") EntityManagerFactory entityManagerFactory
//    ) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//
//    @Bean(name = "moguJdbcTemplate")
//    public JdbcTemplate moguJdbcTemplate(@Qualifier("moguDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//    //public EntityManager getEntityManager() {
//        //return entityManager;
//    //}
//}
