package com.edison.dtproxy.invocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class WorkerProxy implements InvocationHandler {

    private Object target;

    public WorkerProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(target,args);
        return null;
    }
}
