package com.edison.design.demoone.decorate;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-26 15:51
 **/
public class Mocha extends Dressing {
    public Mocha(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost()+1.6;
    }
}
