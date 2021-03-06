package com.proxy;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.*;
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
        }else if(isDefaultMethod(method)){
            return invokeDefaultMethod(proxy, method, args);
        }
        MapperMethod mapperMethod = cachedMapperMethod(method);
        return mapperMethod.execute(args);
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
        final Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, String.class);
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        final Class<?> declaringClass = method.getDeclaringClass();
        return constructor.newInstance(declaringClass, MethodHandles.Lookup.PRIVATE | MethodHandles.Lookup.PROTECTED | MethodHandles.Lookup.PACKAGE | MethodHandles.Lookup.PUBLIC).unreflectSpecial(method, declaringClass).bindTo(proxy).invokeWithArguments(args);
    }

    /**
     * Backport of java.lang.reflect.Method#isDefault()
     */
    private boolean isDefaultMethod(Method method) {
        return (method.getModifiers()
                & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) == Modifier.PUBLIC
                && method.getDeclaringClass().isInterface();
    }

}
