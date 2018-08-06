package com.wangxuebing.design.demoone.proxy;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-07 16:18
 **/
public class TestC implements TestInterface {


    @Override
    public void doSomeThing() {
        System.out.println("TestC ---------- doSomeThing");
    }

    @Override
    public void doAnyThing() {
        System.out.println("TestC ---------- doAnyThing");
    }

    @Override
    public void doNoThing() {
        System.out.println("TestC ---------- doNoThing");
    }
}
