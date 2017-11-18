package com.wangxuebing.thread.volatilet;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 15:20
 **/
public class VolatileTest  {
    private static final int THREAD_COUNT = 20;

    public static volatile int race = 0;

    public static void increase() {
        race++;

    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (Thread thread : threads) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            thread.start();
        }
        System.out.println(race);
    }
}
