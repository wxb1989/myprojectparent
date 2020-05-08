package com.proxy;

import com.service.TestInterface;
import com.service.impl.TestInterfaceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wxb
 * @version V1.0
 * @Package com.proxy
 * @date 2020/5/8 11:11
 */
public class TestUtilProxy implements InvocationHandler {

    private Class<?> interfaceClass;

    public Object bind(Class<?> cls) {
        this.interfaceClass = cls;
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{interfaceClass}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(new TestInterfaceImpl(), args);
    }

}
