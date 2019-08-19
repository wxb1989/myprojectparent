package com.edison.design.demoone.build;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 16:16
 **/
public class ConcreteBuilder implements Builder {

    Product product;

    @Override
    public void setA(String a) {

    }

    @Override
    public void setB(String a) {

    }

    @Override
    public void setC(String a) {

    }

    @Override
    public void setD(String a) {

    }

    @Override
    public Product getResult() {
        return new ConcreteProduct();
    }


}
