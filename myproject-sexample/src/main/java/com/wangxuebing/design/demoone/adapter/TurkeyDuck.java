package com.wangxuebing.design.demoone.adapter;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 15:29
 **/
public class TurkeyDuck implements Duck {

    private Turkey turkey;

    public TurkeyDuck(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
