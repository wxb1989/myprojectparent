package com.edison.design.demotwo.decorator;

public abstract class AbstractSampleExecutor implements  DecoratorInterface {


    @Override
    public void executor() {
        preExecut();
    }

    abstract void preExecut();
}
