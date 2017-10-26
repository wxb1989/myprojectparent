package com.wangxuebing.design.decorate;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-26 15:49
 **/
public class Espresso implements Coffee{


    @Override
    public double cost() {
        return 2.5;
    }
}
