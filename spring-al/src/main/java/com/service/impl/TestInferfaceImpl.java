package com.service.impl;

import com.service.TestInferface;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 */
public class TestInferfaceImpl implements TestInferface, InitializingBean {
    private String hello = "hello";

    public TestInferfaceImpl(){
        System.out.println("hello in contructor:" + hello);
    }


    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    @Override
    public String hello() {
        System.out.println("invoke hello");
        return hello;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init method invoked, hello:" + hello);
    }
}
