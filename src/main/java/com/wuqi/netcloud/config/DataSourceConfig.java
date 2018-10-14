package com.wuqi.netcloud.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

//@Configuration
public class DataSourceConfig {

//    @Bean
//    public DataSource getDataSource() {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        return dataSource;
//    }

//    @Bean
//    public SqlSessionFactoryBean sessionFactory() {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(getDataSource());
//        sessionFactory.setTypeAliasesPackage("com.wuqi.netcloud.entity");
//        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        return sessionFactory;
//    }

}
