package com.service.impl;

import com.service.TestInterface;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 */
public class TestInterfaceImpl implements TestInterface, InitializingBean {
    private String hello = "hello";

    public TestInterfaceImpl(){
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
