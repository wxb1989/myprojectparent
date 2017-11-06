package com.wangxuebing.mtpattern.ch1;

/**
 * @author ${Administrator}
 * @description  线程安全的计数器。
 * @create 2017-11-06 16:28
 **/
public class ThreadSafeCounter {
    private int  counter =0 ;

    public void add(){
        synchronized (this){
            counter++;
        }
    }

    public int get() {
        synchronized (this) {
            return counter;
        }

    }

}
