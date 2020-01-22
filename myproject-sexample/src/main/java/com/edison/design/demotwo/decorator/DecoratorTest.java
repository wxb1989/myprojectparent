package com.edison.design.demotwo.decorator;

public class DecoratorTest {


    public static void main(String[] args) {

        SampleExecutorOne sampleExecutorOne = new SampleExecutorOne();
        DecoratorInterface decoratorInterface = new CashExecutor(sampleExecutorOne);

        decoratorInterface.executor();
    }

}
