package com.support;
import com.service.TestInterface;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 我们可以看出来，BeanPostProcessor是在容器实例化bean之后调用的，通过它可以完成自定义的解析实例化逻辑。
 * 在spring framework中，比较知名的BeanPostProcessor有AutowiredAnnotationBeanPostProcessor和AbstractAdvisorAutoProxyCreator。
 * 为了说明一些简单地用法，我们也可以用BeanPostProcessor做个类似AOP的应用
 */
public class MyBeanPostProcessor implements BeanPostProcessor, BeanClassLoaderAware  {
    private ClassLoader classLoader;

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader=classLoader;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        if(bean instanceof TestInterface){
            System.out.println("invoke before initialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String name) throws BeansException {
        if(bean instanceof TestInterface){
            System.out.println("invoke after initialization");
            TestInterface newProxy = (TestInterface) Proxy.newProxyInstance(classLoader, new Class[]{TestInterface.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("before invoke");
                    Object result = method.invoke(bean, args);
                    if(method.getName().equals("hello")){
                        result = result.toString() + " from proxy";
                    }
                    System.out.println("after invoke");
                    return result;
                }
            });
            return newProxy;
        }
        return bean;
    }
}
