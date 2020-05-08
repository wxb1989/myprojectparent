package com;

import com.service.TestInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SampleApp {
    public static void main(String[] args) {

        /**
         * Mybatis是通过mapper接口生成代理对象的简单实现方法
         * https://blog.csdn.net/chinoukin/article/details/83183149
         *
         */
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(MyConfiguration.class);
      for (String beanDefinitionName : ac.getBeanFactory().getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        TestInterface testInterface = (TestInterface) ac.getBean("testInterface");
        System.out.println(testInterface.hello("test"));

  /*      ApplicationContext context = new ClassPathXmlApplicationContext("xml/beanfactorypostprocessor/config.xml");
        Pc pc = context.getBean(Pc.class);
        System.out.println(pc);*/
    }
}
