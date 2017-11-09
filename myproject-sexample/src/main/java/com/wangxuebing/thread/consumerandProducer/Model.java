package com.wangxuebing.thread.consumerandProducer;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 15:44
 **/
public interface Model {
    Runnable newRunnableConsumer();
    Runnable newRunnableProducer();
}
