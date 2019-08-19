package com.edison.design.demoone.adapter;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 15:27
 **/
public class MallardDuck implements Duck {


    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("Fly");
    }
}
