package com.wangxuebing.design.proxy;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-07 16:18
 **/
public class TestA implements TestInterface {


    @Override
    public void doSomeThing() {
        System.out.println("TestA ---------- doSomeThing");
    }

    @Override
    public void doAnyThing() {
        System.out.println("TestA ---------- doAnyThing");
    }

    @Override
    public void doNoThing() {
        System.out.println("TestA ---------- doNoThing");
    }
}
