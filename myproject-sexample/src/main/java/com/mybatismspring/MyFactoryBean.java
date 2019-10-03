package com.mybatismspring;

import com.mybatismspring.proxy.NbInvocationHandler;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * 实现FactoryBean
 */
public class MyFactoryBean implements FactoryBean {

    Class clas;

    public MyFactoryBean(Class clas) {
        this.clas = clas;
    }

    @Override
    public Object getObject() throws Exception {
        Class<?>[] classz = new Class[]{Class.class};
        Object object = Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(), classz, new NbInvocationHandler());
        System.out.println(object);
        return object;
    }

    @Override
    public Class<?> getObjectType() {
        return clas;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
