package com.wangxuebing.design.demoone.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-07 16:31
 **/
public class ProxyTest {
    public static void main(String[] args) {
        TestInterface userService = new TestA();
        InvocationHandler invocationHandler = new TestProxy(userService);
        TestInterface userServiceProxy = (TestInterface) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), invocationHandler);
        userServiceProxy.doAnyThing();
    }
}
