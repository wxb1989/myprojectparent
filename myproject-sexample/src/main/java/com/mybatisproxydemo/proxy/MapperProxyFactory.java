package com.mybatisproxydemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wxb
 * @version V1.0
 * @Package com.mybatisproxydemo.proxy
 * @date 2020/5/8 15:50
 */
public class MapperProxyFactory<T> {
    private Class<T> mapperInterface;
    private Map<Method, MapperMethod> methodCache = new ConcurrentHashMap<>();

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Class<T> getMapperInterface() {
        return mapperInterface;
    }

    public Map<Method, MapperMethod> getMethodCache() {
        return methodCache;
    }

    protected T newInstance(MapperProxyInvocationHandler<T> proxyInvocationHandler) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, proxyInvocationHandler);
    }

    //外部开放的方法
    public T newInstance() {
        MapperProxyInvocationHandler<T> tMapperProxyInvocationHandler = new MapperProxyInvocationHandler<>(mapperInterface, methodCache);
        return newInstance(tMapperProxyInvocationHandler);
    }
}
