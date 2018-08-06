package com.wangxuebing.design.demoone.proxy;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-07 16:18
 **/
public class TestB implements TestInterface {


    @Override
    public void doSomeThing() {
        System.out.println("TestB ---------- doSomeThing");
    }

    @Override
    public void doAnyThing() {
        System.out.println("TestB ---------- doAnyThing");
    }

    @Override
    public void doNoThing() {
        System.out.println("TestB ---------- doNoThing");
    }
}
