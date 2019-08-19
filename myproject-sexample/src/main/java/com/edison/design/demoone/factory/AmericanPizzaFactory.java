package com.edison.design.demoone.factory;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-01 16:12
 **/
public class AmericanPizzaFactory extends  PizzaFractory {

    @Override
    Pizza createPizza(String type) {
        if(type==null){
            return null;
        }
        if("cheese".equals(type)){
            return new AmericanCheesePizza();
        }else{
            return new AmericanPizza();
        }
    }
}
