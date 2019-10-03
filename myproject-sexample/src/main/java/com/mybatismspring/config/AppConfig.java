package com.mybatismspring.config;

import com.mybatismspring.MyImportBeanDefinitionRegistert;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

/**
 * 配置类
 * @author wangxuebin
 */
@Configuration
@ComponentScan("com.mybatismspring")
//mybatis 扫描dao的包
@MapperScan("com.mybatismspring.dao")
public class AppConfig {

    @Bean
    public DataSource dataSource  (){
        /**
         * 数据源配置，用的是最简单的spring 的jdbc
         */
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://180.106.83.239:46986/cxjk?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Cloud@18915898007");
        return driverManagerDataSource;
    }

    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean;
    }
}
