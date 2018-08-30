package com.wangxuebing.thread.concurrent.example1;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2018-08-28 10:34
 **/
public class ClientB {
    public void get() {
        ThreadShareData shardDataB = ThreadShareData.getCurrentThreadInstance();
        System.out.println(String.format("ClientB name is:%s \t data.name is:%s \t data.age is:%s",
                Thread.currentThread().getName(), shardDataB.getName(), shardDataB.getAge()));
    }
}
