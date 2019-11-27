package com.cxjk.cloud.eurekas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author
 * @package com.cxjk.cloud.eurekas
 * @description
 * @create 2019-11-14 11:54
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EurekaServerApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
