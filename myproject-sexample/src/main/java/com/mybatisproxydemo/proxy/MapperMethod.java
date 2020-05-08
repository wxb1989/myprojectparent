package com.mybatisproxydemo.proxy;

import com.mybatisproxydemo.annotation.Insert;
import com.mybatisproxydemo.annotation.Update;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 接口上面的注释的方法执行处理类
 * @author wxb
 * @version V1.0
 * @Package com.mybatisproxydemo.proxy
 * @date 2020/5/8 15:54
 */
public class MapperMethod {
    private  Method method;
    private  MapperProxyInvocationHandler mapperProxy;
    public MapperMethod(Method method, MapperProxyInvocationHandler mapperProxy) {
        this.method = method;
        this.mapperProxy = mapperProxy;
    }

    public Object execute(Object[] args){
        System.out.println("MapperProxy: " + mapperProxy);
        System.out.println("execute method {" + method.getName() + "}" );


        // 读取mapper.xml中的语句块，并将其作为SqlStatement执行，
        // 方法名获取sql语句，参数通过代理的Invocation等获得
        // 有注解则处理注解中的参数

        // 此处只是简单的模拟一下，实际mybatis的处理方式是很复杂的
        final Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            Class<? extends Annotation> aClass = annotation.annotationType();
            if (aClass.equals(Insert.class)) {
                System.out.println("execute insert {" + args[0] + "} completed");
            }
            if (aClass.equals(Update.class)) {
                System.out.println("execute update {" + args[0] + "} completed");
            }
        }
        return 1;
    }
}
