package com.mybatismspring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * java动态代理要实现InvocationHandler作为参数
 */
public class NbInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        method.getAnnotation(Select)
        return null;
    }
}
