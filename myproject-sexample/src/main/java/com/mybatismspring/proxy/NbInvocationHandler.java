package com.mybatismspring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * java动态代理要实现InvocationHandler作为参数
 */
public class NbInvocationHandler implements InvocationHandler {

    public NbInvocationHandler() {
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return null;
    }
}
