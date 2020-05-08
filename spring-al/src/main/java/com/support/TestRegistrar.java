package com.support;

import com.annotation.TestUtil;
import com.service.TestInterface;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.*;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import java.util.Map;
import java.util.Set;

/**
 * @author wxb
 * @version V1.0
 * @Package com.configuration
 * @date 2020/5/8 9:13
 */
public class TestRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {

    private ResourceLoader resourceLoader;

    private Environment environment;


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        scanner.setResourceLoader(this.resourceLoader);

        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(TestUtil.class);
        scanner.addIncludeFilter(annotationTypeFilter);
        String basePackage = ClassUtils.getPackageName(annotationMetadata.getClassName());
        Set<BeanDefinition> candidateComponents  = scanner.findCandidateComponents(basePackage);
        for (BeanDefinition  holder : candidateComponents ) {
            if (holder instanceof AnnotatedBeanDefinition) {
                AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) holder;
                AnnotationMetadata annotationMeta = beanDefinition.getMetadata();
                Map<String, Object> attributes = annotationMeta.getAnnotationAttributes(TestInterface.class.getCanonicalName());
                //注册自己beanDefinition
                registerTestUtil(beanDefinitionRegistry, annotationMeta);
            }
        }
    }
    private void registerTestUtil(BeanDefinitionRegistry beanDefinitionRegistry, AnnotationMetadata annotationMetadata ) {
        Class<?> cls = TestInterface.class;
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(cls);
        GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
        definition.getPropertyValues().add("interfaceClass", definition.getBeanClassName());
        definition.setBeanClass(TestFactoryBean.class);
        definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        // 注册bean名,一般为类名首字母小写
        beanDefinitionRegistry.registerBeanDefinition("testInterface", definition);

    }

    protected ClassPathScanningCandidateComponentProvider getScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, this.environment) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                if (beanDefinition.getMetadata().isInterface()) {
                    return !beanDefinition.getMetadata().isAnnotation();
                }
                return false;
            }
        };
    }
}
