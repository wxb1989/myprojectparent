package com.edison.thread.consumerandProducer;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 15:41
 **/
public abstract class AbstractConsumer implements Consumer, Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}