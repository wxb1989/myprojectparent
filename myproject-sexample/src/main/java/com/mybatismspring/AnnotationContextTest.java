package com.mybatismspring;

import com.mybatismspring.config.AppConfig;
import com.mybatismspring.dao.NbDao;
import com.mybatismspring.proxy.NbInvocationHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

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
         AnnotationConfigApplicationContext ac
         = new AnnotationConfigApplicationContext();
         ac.addBeanFactoryPostProcessor(new DemBeanFactoryPostProcessor());
         ac.register(MyConfiguration.class);
         ac.refresh();
         System.out.println(ac.getBean("my"));
         System.out.println(ac.getBean("user"));
         */
        AnnotationConfigApplicationContext acp= new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.print(acp.getBean("luban"));

         NbDao dao  =acp.getBean(NbDao.class);
       List list= dao.getEmployees();
       System.out.print(" getEmployees "+list.size());
    }
}

