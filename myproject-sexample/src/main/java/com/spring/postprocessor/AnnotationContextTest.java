package com.spring.postprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ${Administrator}
 * @package com.spring.annotation
 * @description  这是一个通过spring生命周期里的BeanPostProcessor的拓展点来实现的自定义注解分发
 * InitializingBean,DisposableBean BeanFactoryAware,BeanNameAware,ApplicationContextAware
 *
 * @create 2018-11-07 15:15
 **/
public class AnnotationContextTest {

    public static void main(String[] args) {
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Invoker invoker = InvokerHolder.getInvoker("user","login");
        invoker.invkoer(null);
    }
}

