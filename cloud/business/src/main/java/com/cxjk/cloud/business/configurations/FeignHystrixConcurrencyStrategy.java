package com.cxjk.cloud.business.configurations;


import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;

/**
 *
 * Hystrix default Strategy is THREAD,but RequestContextHolder.getRequestAttributes() is in ThreadLocal params
 * THREAD Strategy don't get the ThreadLocal params
 * reference :org.springframework.cloud.sleuth.instrument.hystrix.SleuthHystrixConcurrencyStrategy
 * read SleuthHystrixConcurrencyStrategy that can get Context in thread
 */
public class FeignHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {

    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        RequestAttributes attributes =  RequestContextHolder.getRequestAttributes();
        HystrixCustomizeCallable hystrixCustomizeCallable = new HystrixCustomizeCallable(attributes, callable);
        return hystrixCustomizeCallable;
    }
}

class HystrixCustomizeCallable<T> implements Callable<T>{

    private RequestAttributes attributes;

    private Callable<T> callable;

    public HystrixCustomizeCallable(RequestAttributes attributes, Callable<T> callable){
        this.attributes = attributes;
        this.callable = callable;
    }

    @Override
    public T call() throws Exception {
        try{
            if(null != this.attributes){
                RequestContextHolder.setRequestAttributes(this.attributes);
            }
            return this.callable.call();
        }finally {
            RequestContextHolder.resetRequestAttributes();
        }
    }
}