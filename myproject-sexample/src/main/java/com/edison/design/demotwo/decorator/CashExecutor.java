package com.edison.design.demotwo.decorator;

public class CashExecutor  implements DecoratorInterface{
    SampleExecutorOne sampleExecutorOne ;


    public CashExecutor(SampleExecutorOne sampleExecutorOne) {
        this.sampleExecutorOne = sampleExecutorOne;
    }

    @Override
    public void say() {
        sampleExecutorOne.say();
    }

    @Override
    public void hellow() {
        sampleExecutorOne.hellow();
    }

    @Override
    public void executor() {
        sampleExecutorOne.executor();
    }

    @Override
    public void postExecutor() {
        sampleExecutorOne.preExecut();
    }
}
