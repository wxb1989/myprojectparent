package com.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 这个描述比较清楚了，BeanFactoryPostProcessor可以在容器初始化创建bean之前读他们的元数据信息并能够修改它。
 * 在spring framework中，一个比较典型的例子就是PropertySourcesPlaceholderConfigurer，
 * 它能通过阅读bean的元信息并结合配置属性源来修改bean definition来完成配置属性注入的功能。
 * MyBeanFactoryPostProcessor
 * 这里我们实际上就是获取了TestImpl的元数据，读取并修改了属性，
 * 将hello属性的值改为hello world，这样就让我们再通过http请求访问调用hello方法的时候就能看到我们修改后的值了。
 * 我们再通过我们的ImportBeanDefinitionRegistrar来把我们的MyBeanFactoryPostProcessor注册上去
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //可以在这里获取已经注册到BeanFactory里的类，然后去操作他们
      /*  BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(ClassUtils.getShortName(TestInterface.class));
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.add("hello", "hello world");*/
    }
}
