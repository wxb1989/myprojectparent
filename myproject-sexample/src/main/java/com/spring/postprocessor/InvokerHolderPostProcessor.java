package com.spring.postprocessor;

import com.spring.postprocessor.annotation.Cmd;
import com.spring.postprocessor.annotation.Model;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 *@author  edsion
 *  //注意：这里有个bug就是bean的实现方法必须在
 *  postProcessBeforeInitialization方法里实现否则会报NoSuchBeanDefinitionException错
 *
 *  InitializingBean是spring提供的所有自己的类都可以实现的一个接口
 *  关于spring在拓展点来实现自己在业务非常的文章 https://blog.csdn.net/boling_cavalry/article/details/81474340
 */
@Component
public class InvokerHolderPostProcessor implements BeanPostProcessor  , InitializingBean {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行了postProcessBeforeInitialization方法");
        Class<?> beanClass = bean.getClass();
        Class<?>[] classInterfaces = beanClass.getInterfaces();
        if(classInterfaces != null  || classInterfaces.length>0){
            for (Class<?> anInterface : classInterfaces) {
                Model model=anInterface.getAnnotation(Model.class);
                if(model == null ){
                    continue;
                }
                Method[] methods=anInterface.getMethods();
                for (Method method : methods) {
                    Cmd cmd=method.getAnnotation(Cmd.class);
                    if (cmd == null) {
                        continue;
                    }
                    String modelVal = model.modelVal();
                    String cmdVal = cmd.cmdVal();

                    Invoker invoker =Invoker.getInvoker(bean,method);

                    if (InvokerHolder.getInvoker(modelVal, cmdVal) == null) {
                        InvokerHolder.addInvoker(modelVal, cmdVal,invoker);
                    }else{
                        System.out.println("重复的执行器 : "+ modelVal + cmdVal);
                    }
                }
            }
        }
        return bean;
    }

    /**
     * 在bean实例化后调用，如果bean实现了InitializingBean，
     * 则在执行完 该接口的afterPropertiesSet方法后调用 ，
     * 如果实现了init-method则 * 在执行完init-method后调用
     * */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行了postProcessAfterInitialization方法");

       return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行了afterPropertiesSet方法");
    }
}
