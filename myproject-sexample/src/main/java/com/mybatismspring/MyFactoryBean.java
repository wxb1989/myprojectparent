package com.mybatismspring;

import com.mybatismspring.dao.NbDao;
import com.mybatismspring.dao.UserTDao;
import com.mybatismspring.proxy.NbInvocationHandler;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * 实现FactoryBean
 */
public class MyFactoryBean implements FactoryBean{

    Class clas ;

    @Override
    public Object getObject() throws Exception {
        Class<?>[] classz = new Class[]{Class.class};
        Object object =  Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(), classz, new NbInvocationHandler());
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
