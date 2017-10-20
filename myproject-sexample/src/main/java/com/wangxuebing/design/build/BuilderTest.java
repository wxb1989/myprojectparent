package com.wangxuebing.design.build;

/**
 * @author ${Administrator}
 * @description
 *
 * 构造器模式
 *
 * @create 2017-10-19 16:19
 **/
public class BuilderTest {


    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director();
        director.setBuilder(builder);
        Product product=director.construct();
        product.show();
    }
}
