package com.wangxuebing.design.demoone.decorate;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-26 15:51
 * 装饰模式分为3个部分：
    1，抽象组件 -- 对应Coffee类
    2，具体组件 -- 对应具体的咖啡，如：Decaf，Espresso
    3，装饰者 -- 对应调味品，如：Mocha，Whip
    装饰模式有3个特点：
    1，具体组件和装饰者都继承自抽象组件(Decaf、Espresson、Mocha和Whip都继承自Coffee)，并且装饰者持有抽象组件的引用
    2，可以使用装饰者组合具体组件创造出新的类(Mocha组合Decaf创造出MochaDecaf)
    3，过程2可以重复，直到创造出需要的类
    使用装饰模式，想要获得一个WhipDoubleMochaEspresso是很容易的：
 **/
public class Test {
    public static void main(String[] args) {
        Coffee coffee = new Espresso();
        coffee = new Mocha(coffee);
        coffee = new Whip(coffee);
        coffee = new Whip(coffee);
        coffee = new Mocha(coffee);
        System.out.println(coffee.cost());

    }
}
