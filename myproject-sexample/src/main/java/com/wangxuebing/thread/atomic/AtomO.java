package com.wangxuebing.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 16:02
 **/
public class AtomO {

    private final AtomicInteger value = new AtomicInteger(0);
    private int no =0;

    public int getValue(){
        return value.get();
    }

    public int getNextValue(){
        return value.incrementAndGet();
    }

    public int getPreviousValue(){
        return value.decrementAndGet();
    }

    public void getAndSet(int newValue){
        value.getAndSet(newValue);
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
