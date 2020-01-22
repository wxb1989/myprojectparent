package com.edison.design.demotwo.decorator;

public class SampleExecutorTwo extends AbstractSampleExecutor{


    @Override
    void preExecut() {
        System.out.println("preExecut");
    }

    @Override
    public void say() {
        System.out.println("say");
    }

    @Override
    public void hellow() {
        System.out.println("hellow");
    }

    @Override
    public void postExecutor() {
        System.out.println("postExecutor");
    }
}
