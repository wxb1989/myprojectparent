package com.edison.design.demotwo.strategy;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2018-08-06 15:43
 * 设计模式-策略模式-抽象策略/算法 5折支付-也可能是微信支付或者支付宝支付
 **/
public class FiveFoldStrategy extends  AbstarctStrategy {


    @Override
    public double countMoney(double money) {

        checkMoney(money);

        return money*0.5;
    }
}