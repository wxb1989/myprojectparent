package com.wangxuebing.design.factory;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-01 16:11
 **/
public class AmericanPizza implements Pizza {

    @Override
    public void taste() {
        System.out.println("AmericanPizza    taste");
    }
}
