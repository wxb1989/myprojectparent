package com.spring;

import com.spring.annotation.configuration.MyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ${Administrator}
 * @package com.spring.annotation
 * @description ${DESCRIPTION}
 * InitializingBean,DisposableBean BeanFactoryAware,BeanNameAware,ApplicationContextAware
 * @create 2018-11-07 15:15
 **/
public class AnnotationContextTest {

    public static void main(String[] args) {
        /**
         spring开闭原则体现的 淋漓精致

         第一种实例化方式 这种方式在spring原码里是
         低于spring的BeanFactoryPostProcessor的生命周期
         加了@compont的的DemBeanFactoryPostProcessor,要在后面才能拿到,有时候会不好做拓展
         第二种实例化方式 这种方式在spring原码里是
         高于spring的BeanFactoryPostProcessor的生命周期

         第一种
         AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(MyConfiguration.class);

         第二种
         */
       AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext();
        ac.addBeanFactoryPostProcessor(new DemBeanFactoryPostProcessor());
        ac.register(MyConfiguration.class);
        ac.refresh();
        System.out.println(ac.getBean("my"));
        System.out.println(ac.getBean("user"));
        System.out.println(ac.getBean("testDao"));


    }
}

