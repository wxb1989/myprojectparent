package com.support;

import com.annotation.TestUtil;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * @author wxb
 * @version V1.0
 * @Package com.configuration
 * @date 2020/5/7 17:06
 */
public class MyTestUtilClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner  {

    public MyTestUtilClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
    }

    public MyTestUtilClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }

    public MyTestUtilClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters, Environment environment) {
        super(registry, useDefaultFilters, environment);
    }

    public MyTestUtilClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters, Environment environment, ResourceLoader resourceLoader) {
        super(registry, useDefaultFilters, environment, resourceLoader);
    }

    protected void registerFilters() {
        addIncludeFilter(new AnnotationTypeFilter(TestUtil.class));
    }
    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
