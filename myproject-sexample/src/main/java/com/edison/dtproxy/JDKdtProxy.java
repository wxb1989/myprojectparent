package com.edison.dtproxy;

import com.edison.dtproxy.beand.Boss;
import com.edison.dtproxy.beand.IBuilder;
import com.edison.dtproxy.invocationhandler.WorkerProxy;
import com.edison.dtproxy.invocationhandler.WorkerProxyCglib;
import com.edison.dtproxy.invocationhandler.WorkerProxyJavassist;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Proxy;

public class JDKdtProxy {

    public static void main(String[] args) {
        /**
         * 动态代理的三种实现方式
         原理：利用反射去调方法，Proxy这个类就是java.lang.reflect包下面的

         拿到被代理类的class对象 --target

         动态生成一个代理类CLASSA（class com.sun.proxy.$Proxy3），这类实现被代理类的所有接口

         获取这个CLASSA的一个参数为InvocationHandler的构造方法

         调用这个构造方法创建实例（这个就是代理对象）；参数就是这个代理类WorkerProxy
         */
        //jdk的动态代理实现方式
        IBuilder builder1 = (IBuilder) Proxy.newProxyInstance(JDKdtProxy.class.getClassLoader(),
                new Class[]{IBuilder.class}, new WorkerProxy(new Boss()));
        builder1.buildHouse();

        //cglib的动态代理实现方式 代理类通过字节码技术创建一个被代理类的子类实例
        WorkerProxyCglib worker = new WorkerProxyCglib();
        IBuilder builder = (IBuilder) worker.getProxy(Boss.class);
        builder.buildHouse();

       // javassist
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(Boss.class);
        Class<?> clazz = factory.createClass();
        IBuilder testDemo = null;
        try {
            testDemo = (IBuilder) clazz.newInstance();
            ((ProxyObject)testDemo).setHandler(new WorkerProxyJavassist());
            testDemo.buildHouse();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
