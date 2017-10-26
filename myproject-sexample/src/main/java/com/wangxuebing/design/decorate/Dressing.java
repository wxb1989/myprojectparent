package com.wangxuebing.design.decorate;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-26 15:49
 **/
public class Dressing implements Coffee {

    protected  Coffee coffee;

    public Dressing(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost();
    }
}
