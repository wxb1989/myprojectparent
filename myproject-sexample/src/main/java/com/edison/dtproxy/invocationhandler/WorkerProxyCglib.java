package com.edison.dtproxy.invocationhandler;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class WorkerProxyCglib implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class<?> clazz) {
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术，动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("员工建房子");
        return methodProxy.invokeSuper(o, objects);
    }
}
