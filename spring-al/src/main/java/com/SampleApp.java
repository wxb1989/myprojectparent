package com;

import com.service.TestInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SampleApp {
    public static void main(String[] args) {

        /**
         Pc Info: Graphics=Nvdia, Cpu=Amd, Ram=Kingston]
         */
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(MyConfiguration.class);
        for (String beanDefinitionName : ac.getBeanFactory().getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        TestInterface testInterface = (TestInterface) ac.getBean("testInterface");
        System.out.println(testInterface.hello());

  /*      ApplicationContext context = new ClassPathXmlApplicationContext("xml/beanfactorypostprocessor/config.xml");
        Pc pc = context.getBean(Pc.class);
        System.out.println(pc);*/
    }
}
