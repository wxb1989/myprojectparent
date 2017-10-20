package com.wangxuebing.design.adapter;

/**
 * @author ${Administrator}
 * @description
 *  适配器模式的测试类
 *      Duck 接口     --->    MallardDuck
 *      Turkey 接口   --->    WildTurkey
 *
 *      TurkeyDuck实现了Duck接口的方法，但是在内部调用的确实Turkey的实现类里的方法
 *
 * @create 2017-10-19 15:24
 **/
public class AdapterTest {

    public static void main(String[] args) {

        Duck duck =new TurkeyDuck(new WildTurkey());
        duck.fly();
        duck.quack();

        if(duck instanceof TurkeyDuck){
            TurkeyDuck turkeyDuck = (TurkeyDuck) duck;
            System.out.println("instanceof");
        }
    }
}
