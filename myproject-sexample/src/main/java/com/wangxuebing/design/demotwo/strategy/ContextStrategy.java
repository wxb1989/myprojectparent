package com.wangxuebing.design.demotwo.strategy;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2018-08-06 15:45
 * 上下文管理对象，不能直接访问策略的主要实现类
 **/
public class ContextStrategy {

    private final AbstarctStrategy strategy;


    public ContextStrategy(AbstarctStrategy strategy) {

        if (strategy == null){
            throw new RuntimeException("instantiation ContextStrategy faild，Must choose a strategy");
        }
        this.strategy = strategy;
    }

    /**
     * 可以定义一个枚举，入参时发送一个某个策略对应的枚举值
     * @param type
     */
    public ContextStrategy(int type){

        switch (type){
            //八折策略
            case 8:
                strategy = new EightFoldStrategy();
                break;
            //五折策略
            case 5:
                strategy = new FiveFoldStrategy();
                break;
            default:
                throw new RuntimeException("instantiation ContextStrategy faild，Must choose a strategy");
        }
    }

    /**
     * 执行策略
     * @param money
     * @return
     */
    public double excuteStrategy(double money){

        /**
         * 这里是根据优惠折扣算法计算金额
         */
        return strategy.countMoney(money);
    }
}
