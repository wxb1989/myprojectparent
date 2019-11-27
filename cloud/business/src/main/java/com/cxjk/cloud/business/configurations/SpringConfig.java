package com.cxjk.cloud.business.configurations;

import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@Configuration
public class SpringConfig {

    @Bean
    @LoadBalanced
    RestTemplate loadBalanced() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Primary
    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }

    @Bean
    @Primary
    Retryer feignRetry() {
        return Retryer.NEVER_RETRY;
    }

    @Bean
    public RequestInterceptor headerInterceptor() {
        return requestTemplate -> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            requestTemplate.header("Authorization", request.getHeader("Authorization"));
        };
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES)); //KB,MB
        /// 设置总上传数据总大小50M
        factory.setMaxRequestSize(DataSize.of(50, DataUnit.MEGABYTES));//KB,MB
        return factory.createMultipartConfig();
    }
}
