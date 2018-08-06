package com.wangxuebing.design.demoone.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-07 16:16
 **/
public class TestProxy implements InvocationHandler {

    private Object target;

    public TestProxy() {
        super();
    }

    public TestProxy(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
      if("doSomeThing".equals(method.getName())){
           result =  method.invoke(target,args);
      }else{
          result =  method.invoke(target,args);
      }
        return result;
    }
}
