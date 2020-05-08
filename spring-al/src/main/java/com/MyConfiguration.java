package com;

import com.annotation.EnableTest;
import com.annotation.TestUtil;
import com.service.TestInterface;
import com.service.impl.TestInterfaceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ${Administrator}
 * @package com.spring.annotation.configuration
 * @description spring注解方式的注册类
 * @create 2018-11-07 15:17
 **/
@Configuration
@EnableTest
public class MyConfiguration {

    @Bean
    public String my() {
        return "aaa";
    }



}
