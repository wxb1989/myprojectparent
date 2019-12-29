package com.spring;


import com.spring.annotation.configuration.TestDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 主流框架都是通过过这个拓展点来修改beanfactory里加载出来的bean
 * 或者实现BeanDefinitionRegistryPostProcessor
 * 例如mybites
 */
public class DemBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        /**
         * 实验一下自己操作BeanFactory，修改它里面已经注册的类，但是TestDao没有注入到spring里去

         GenericBeanDefinition beanDefinition = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition("user");
         beanDefinition.setBeanClass(TestDao.class);
         */
        /**
         * 还可以自己吧这个类加进去，这种方式不太好
         * */
        configurableListableBeanFactory.registerSingleton("testDao", TestDao.class);
    }
}
