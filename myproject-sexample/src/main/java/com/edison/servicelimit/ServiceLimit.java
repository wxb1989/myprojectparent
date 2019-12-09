package com.edison.servicelimit;

import java.lang.annotation.*;

/**
 * 自定义注解  限流
 * 博客 https://blog.52itstyle.vip
 * 创建时间 2019年8月15日
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLimit {

    /**
     * 描述
     */
    String description()  default "";

    /**
     * key
     */
    String key() default "";

    /**
     * 类型
     */
    LimitType limitType() default LimitType.CUSTOMER;

    enum LimitType {
        /**
         * 自定义key
         */
        CUSTOMER,
        /**
         * 根据请求者IP
         */
        IP
    }
}
