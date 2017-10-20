package com.wangxuebing.design.build;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 16:18
 **/
public class Director {

    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.setA("aaa");
        builder.setB("bbb");
        builder.setC("ccc");
        builder.setD("ddd");
        return builder.getResult();
    }
}
