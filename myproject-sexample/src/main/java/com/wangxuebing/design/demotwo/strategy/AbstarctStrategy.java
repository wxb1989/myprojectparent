package com.wangxuebing.design.demotwo.strategy;

/**
 * 策略模式基类
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2018-08-06 15:40
 * 设计模式-策略模式-抽象策略/算法
 **/
public abstract class AbstarctStrategy {

    /**
     * 计算金额抽象接口
     * @param money
     * @return
     */
    public abstract double countMoney(double money);

    /**
     * 不属于策略模式关键部分，我额外定义对参数进行检查的方法
     * 检查金额
     * @param money
     * @return
     */
    protected double checkMoney(double money){
        if (money == 0){
            //TODO 处理为0时逻辑
        }

        return money;
    }
}
