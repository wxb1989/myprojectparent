package com.proxy;

import com.service.TestInterface;
import com.service.impl.TestInterfaceImpl;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wxb
 * @version V1.0
 * @Package com.proxy
 * @date 2020/5/8 11:11
 */
public class MapperProxy implements InvocationHandler {

    private Class<?> interfaceClass;
    private  Map<Method, MapperMethod> methodCache;


    public Object bind(Class<?> cls) {
        this.interfaceClass = cls;
        methodCache = new ConcurrentHashMap<>();
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{interfaceClass}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
            // 针对接口的不同方法书写我们具体的实现
        }else {
            MapperMethod mapperMethod = cachedMapperMethod(method);
            return mapperMethod.execute(args);
//            return invokeDefaultMethod(proxy, method, args);
        }
    }
    private MapperMethod cachedMapperMethod(Method method) {
        MapperMethod mapperMethod = methodCache.get(method);
        if (mapperMethod == null) {
            mapperMethod = new MapperMethod(method, this);
            methodCache.put(method, mapperMethod);
        }
        return mapperMethod;
    }

    private Object invokeDefaultMethod(Object proxy, Method method, Object[] args)
            throws Throwable {
        final Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class
                .getDeclaredConstructor(Class.class, int.class);
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        final Class<?> declaringClass = method.getDeclaringClass();
        return constructor
                .newInstance(declaringClass,
                        MethodHandles.Lookup.PRIVATE | MethodHandles.Lookup.PROTECTED
                                | MethodHandles.Lookup.PACKAGE | MethodHandles.Lookup.PUBLIC)
                .unreflectSpecial(method, declaringClass).bindTo(proxy).invokeWithArguments(args);
    }

}
