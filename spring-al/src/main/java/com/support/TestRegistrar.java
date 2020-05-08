package com.support;

import com.annotation.Mapper;
import com.service.TestInterface;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
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
import org.springframework.util.StringUtils;

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
        //扫包扫到这个注解
        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(Mapper.class);
        scanner.addIncludeFilter(annotationTypeFilter);
        String basePackage = ClassUtils.getPackageName(annotationMetadata.getClassName());
        //获取所有的类
        Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
        for (BeanDefinition holder : candidateComponents) {
            if (holder instanceof AnnotatedBeanDefinition) {
                try {
                    //根据包路径转换成class对象
                    AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) holder;
                    Class clz=Class.forName(beanDefinition.getBeanClassName());
                    //获取类名，并且转成首字母小写
                    String interfaceClassName=toLowerCaseFirstOne(ClassUtils.getShortName(beanDefinition.getBeanClassName()));
                    AnnotationMetadata annotationMeta = beanDefinition.getMetadata();
                    Map<String, Object> attributes = annotationMeta.getAnnotationAttributes(clz.getCanonicalName());
                    //注册自己beanDefinition
                    registerTestUtil(beanDefinitionRegistry, clz,interfaceClassName,annotationMeta);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }



    private void registerTestUtil(BeanDefinitionRegistry beanDefinitionRegistry, Class cls,String className ,AnnotationMetadata annotationMeta) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(cls);
        GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
        definition.getPropertyValues().add("interfaceClass", definition.getBeanClassName());
        definition.setBeanClass(TestFactoryBean.class);
        definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        // 注册bean名,一般为类名首字母小写
        beanDefinitionRegistry.registerBeanDefinition(className, definition);

    }

    private static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
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
