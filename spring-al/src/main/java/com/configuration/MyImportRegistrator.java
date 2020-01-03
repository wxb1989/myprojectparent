package com.configuration;

import com.annotation.TestUtil;
import com.service.TestInferface;
import com.service.impl.TestInferfaceImpl;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

/**
 * 扩展点 ImportBeanDefinitionRegistrar
 * 这个类需要与@Import和@Configuration共同配合使用。
 * 一般来说@Import可以导入三种bean
 * 普通的bean class
 * ImportSelector 这个类可以通过自定义一些条件来控制classpath中需要导入的class
 * ImportBeanDefinitionRegistrar 这个类可以通过代码来动态加载bean，这些bean可以是普通的定义好的class也可以是动态代理。
 * 通过查看代码我们可以知道，spring cloud中的一些常用的注解，包括@EnableFeignClients,@EnableDubboConfig等都是通过ImportBeanDefinitionRegistrar来动态注入的服务调用类到spring容器里面。因此，我们就明确了这个类算是一个比较重要的spring扩展点。
 * 为了搞清楚它的用法，我们就模拟@EnableFeignClients来做一个动态注入的例子（在本文中实际上是个伪动态，只是说明原理）。
 * <p>
 * 作者：ro9er
 * 链接：https://www.jianshu.com/p/1e212eac42ac
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author wangxuebin
 */
public class MyImportRegistrator implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        // 创建一个classpath的scanner
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        // 添加一个扫描的拦截器，只让被TestUtil注解装饰的class 接口通过
        scanner.addIncludeFilter(new AnnotationTypeFilter(TestUtil.class));
        //便利所有有这个注解的接口，处理BeanDefinition元信息
        for (BeanDefinition beanDefinition : scanner.findCandidateComponents(ClassUtils.getPackageName(annotationMetadata.getClassName()))) {
            // 对于扫描出来的BeanDefinition，如果class是TestInferface
            if (beanDefinition.getBeanClassName().equals(TestInferface.class.getCanonicalName())) {
                // TestInferfaceImpl class 添加到beanDefinitionRegistry
                // 方便后面容器启动创建bean的时候创建出来
                beanDefinition.setBeanClassName(TestInferfaceImpl.class.getCanonicalName());
                beanDefinitionRegistry.registerBeanDefinition(ClassUtils.getShortName(TestInferface.class), beanDefinition);
            }
        }
        // 注入beanFactoryPostProcessor
        GenericBeanDefinition beanPostFactoryPostProcessor = new GenericBeanDefinition();
        beanPostFactoryPostProcessor.setBeanClass(MyBeanFactoryPostProcessor.class);
        beanDefinitionRegistry.registerBeanDefinition("myBeanPostFactoryPostProcessor", beanPostFactoryPostProcessor);

        // 注入beanPostProcessor
        GenericBeanDefinition beanPostProcessor = new GenericBeanDefinition();
        beanPostProcessor.setBeanClass(MyBeanPostProcessor.class);
        beanDefinitionRegistry.registerBeanDefinition("myBeanPostProcessor", beanPostProcessor);
    }

    private ClassPathScanningCandidateComponentProvider getScanner() {
        // 创建一个class path scanner
        return new ClassPathScanningCandidateComponentProvider(false, environment) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                // 只要候选的class是个interface就让他过
                return beanDefinition.getMetadata().isInterface();
            }
        };
    }
}
