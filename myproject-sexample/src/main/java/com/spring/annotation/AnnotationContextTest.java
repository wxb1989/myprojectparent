package com.spring.annotation;

import com.spring.annotation.configuration.MyConfiguration;
import com.spring.annotation.configuration.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author ${Administrator}
 * @package com.spring.annotation
 * @description ${DESCRIPTION}
 * InitializingBean,DisposableBean BeanFactoryAware,BeanNameAware,ApplicationContextAware
 * @create 2018-11-07 15:15
 **/
public class AnnotationContextTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class,User.class);
        System.out.println(annotationConfigApplicationContext.getBean("my"));
        System.out.println(annotationConfigApplicationContext.getBean("user"));

    }
}

