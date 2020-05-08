package com.support;

import com.proxy.TestUtilProxy;
import com.service.TestInterface;
import com.service.impl.TestInterfaceImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wxb
 * @version V1.0
 * @Package com.configuration
 * @date 2020/5/8 9:20
 */
public class TestFactoryBean implements FactoryBean<Object>, InitializingBean {

    private Class<?> interfaceClass;

    @Override
    public Object getObject() throws Exception {
        return createProxy();
    }

    @Override
    public Class<?> getObjectType() {
        return this.interfaceClass;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }
    @Override
    public boolean isSingleton() {
        // 单例模式
        return true;
    }

    /**
     * 创建代理类，在代理类中执行真正的操作
     */
    private Object createProxy() {
        return new TestUtilProxy().bind(interfaceClass);
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
}
