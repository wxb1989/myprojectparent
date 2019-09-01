package com.spring.postprocessor.annotation;

import java.lang.annotation.*;

/**
 * @author wangxuebin
 * 自定义的注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Model {

    /**
     *
     * @return
     */
    String modelVal() default "";
}
