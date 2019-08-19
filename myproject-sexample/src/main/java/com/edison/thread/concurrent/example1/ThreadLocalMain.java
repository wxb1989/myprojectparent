package com.edison.thread.concurrent.example1;

import java.util.Random;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2018-08-28 10:35
 **/
public class ThreadLocalMain {

    public static void main(String[] args) {

        //同时启动ClientA和ClientB两次线程,查看打印结果
        for (int i = 0; i < 2; i++) {

            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    //生成随机数
                    int currentRandomInt = new Random().nextInt();
                    System.out.println(String.format("%s--%d", Thread.currentThread().getName(), currentRandomInt));
                    ThreadShareData shardData = ThreadShareData.getCurrentThreadInstance();
                    shardData.setName(String.format("name:%d", currentRandomInt));
                    shardData.setAge(currentRandomInt);

                    //输出两个模块的值
                    new ClientA().get();
                    new ClientB().get();

                }
            });
            th.start();
        }
    }
}
