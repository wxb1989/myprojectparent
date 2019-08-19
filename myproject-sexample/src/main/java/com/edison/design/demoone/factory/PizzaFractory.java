package com.edison.design.demoone.factory;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-01 16:09
 **/
public abstract class PizzaFractory {

    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.taste();

        return pizza;
    }



    abstract Pizza createPizza(String type);
}
