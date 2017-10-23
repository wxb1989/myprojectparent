package com.wangxuebing.design.chain.example;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-20 16:40
 **/
public abstract class Manager {


    String name ;

    protected Manager superior;
    public Manager(String name) {
        this.name = name;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    protected abstract void requestApplication(Request request);
}
