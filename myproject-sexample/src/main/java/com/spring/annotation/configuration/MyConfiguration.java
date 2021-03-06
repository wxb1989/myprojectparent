package com.spring.annotation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ${Administrator}
 * @package com.spring.annotation.configuration
 * @description spring注解方式的注册类
 * @create 2018-11-07 15:17
 **/
@Configuration
@ComponentScan("com.spring")
public class MyConfiguration {

    @Bean
    public String my() {
        return "aaa";
    }

    @Bean
    public User user() {
        return new User();
    }

}
