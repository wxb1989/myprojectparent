package com.edison.design.demoone.adapter;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 15:28
 **/
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
