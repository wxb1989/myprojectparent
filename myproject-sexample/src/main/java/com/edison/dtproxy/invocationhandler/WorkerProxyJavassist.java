package com.edison.dtproxy.invocationhandler;

import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;

public class WorkerProxyJavassist implements MethodHandler {

    @Override
    public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3) throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("PROXY");
        return arg2.invoke(arg0, arg3);
    }

}
