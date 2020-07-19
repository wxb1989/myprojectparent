package com.mybatisproxydemo.annotation;

import java.lang.annotation.*;

/**
 * @author wxb
 * @version V1.0
 * @Package com.mybatisproxydemo.annotation
 * @date 2020/5/8 15:45
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Update {
}
