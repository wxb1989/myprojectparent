package com;

import com.configuration.MyBeanFactoryPostProcessor;
import com.configuration.MyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SampleApp {
    public static void main(String[] args) {

        /**
         Pc Info: Graphics=Nvdia, Cpu=Amd, Ram=Kingston]
         */
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(MyConfiguration.class);

  /*      ApplicationContext context = new ClassPathXmlApplicationContext("xml/beanfactorypostprocessor/config.xml");
        Pc pc = context.getBean(Pc.class);
        System.out.println(pc);*/
    }
}
