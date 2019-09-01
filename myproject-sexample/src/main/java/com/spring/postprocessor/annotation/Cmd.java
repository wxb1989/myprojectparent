package com.spring.postprocessor.annotation;

import java.lang.annotation.*;

/**
 * @author wangxuebin
 * 自定义的注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cmd {

    String cmdVal() default "";
}
