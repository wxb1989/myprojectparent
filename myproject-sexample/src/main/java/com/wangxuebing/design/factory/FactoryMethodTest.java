package com.wangxuebing.design.factory;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-01 16:16
 **/
public class FactoryMethodTest {

    public static void main(String[] args) {
         PizzaFractory pizzaFactory = new AmericanPizzaFactory();
        pizzaFactory.orderPizza("cheese");
    }
}
