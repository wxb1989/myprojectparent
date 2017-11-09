package com.wangxuebing.thread.consumerandProducer;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 15:43
 **/
public abstract class AbstractProducer  implements  Producer,Runnable{

    @Override
    public void run() {
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
