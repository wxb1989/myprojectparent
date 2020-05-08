package com.proxy;

import java.lang.reflect.Method;

/**
 * @author wxb
 * @version V1.0
 * @Package com.proxy
 * @date 2020/5/8 14:09
 */
public class MapperMethod {
    private final Method method;
    private final MapperProxy mapperProxy;

    public MapperMethod(Method method, MapperProxy mapperProxy) {
        this.method = method;
        this.mapperProxy = mapperProxy;
    }

    public Object execute(Object[] args){
        System.out.println("MapperProxy: " + mapperProxy);
        System.out.println("execute method {" + method.getName() + "}" );


        // 读取mapper.xml中的语句块，并将其作为SqlStatement执行，
        // 方法名获取sql语句，参数通过代理的Invocation等获得
        // 有注解则处理注解中的参数

        // 此处只是简单的模拟一下
        System.out.println("execute insert {" + mapperProxy.toString() + "} completed");

        /*final Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            Class<? extends Annotation> aClass = annotation.annotationType();
            if (aClass.equals(Insert.class)) {
                System.out.println("execute insert {" + args[0] + "} completed");
            }
            if (aClass.equals(Update.class)) {
                System.out.println("execute update {" + args[0] + "} completed");
            }
        }*/
        return 1;
    }

}
