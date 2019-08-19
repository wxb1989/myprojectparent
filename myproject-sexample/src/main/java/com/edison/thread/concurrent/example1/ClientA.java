package com.edison.thread.concurrent.example1;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2018-08-28 10:34
 **/
public class ClientA {
    public void get() {
        ThreadShareData shardDataA = ThreadShareData.getCurrentThreadInstance();
        System.out.println(String.format("ClientA name is:%s \t data.name is:%s \t data.age is:%s",
                Thread.currentThread().getName(), shardDataA.getName(), shardDataA.getAge()));
    }
}
