package com.edison.design.demoone.decorate;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-26 15:50
 **/
public class Whip extends Dressing {

    public Whip(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost(){
        return super.cost() + 0.1;
    }
}
