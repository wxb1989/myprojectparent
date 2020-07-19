package com.mybatisproxydemo.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author wxb
 * @version V1.0
 * @Package com.mybatisproxydemo.proxy
 * @date 2020/5/8 15:51
 */
public class MapperProxyInvocationHandler<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -5071502268794599403L;
    private  Class<?> mapperInterfaceClass;
    private Map<Method,MapperMethod> methodCache;


    public MapperProxyInvocationHandler(Class<T> mapperInterfaceClass, Map<Method, MapperMethod> methodCache) {
        this.mapperInterfaceClass = mapperInterfaceClass;
        this.methodCache = methodCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())){
           return method.invoke(this,args);
        }
        final MapperMethod mapperMethod = cachedMapperMethod(method);
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
}
