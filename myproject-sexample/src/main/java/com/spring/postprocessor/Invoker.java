package com.spring.postprocessor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author edison
 * 根据反射得到的对象然后可以调用这个执行器-然后由method去执行invoke方法
 */
public class Invoker {


    Object target;
    Method method;


    /**
     * 获取执行器
     */
    public static  Invoker getInvoker(Object target,Method method){
        Invoker invoker = new Invoker();
        invoker.setObject(target);
        invoker.setMethod(method);
        return invoker;
    }

    /**
     * 传入对象执行器-然后去执行invoke方法
     * @param args
     * @return
     */
    public  Object invkoer(Object[] args){
        try {
            method.invoke(target,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Invoker() {
    }

    public void setObject(Object target) {
        this.target = target;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
