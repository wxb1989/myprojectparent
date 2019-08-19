package com.edison.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 16:02
 **/
public class AtomO {

    /*
    public final int get()	取得当前值
    public final void set(int newValue)	设置当前值
    public final int getAndSet(int newValue)	设置新值，并返回旧值
    public final boolean compareAndSet(int expect, int u)	如果当前值为expect，则设置为u,否则则不进行修改
    public final int getAndIncrement()	当前值加1，返回旧值
    public final int getAndDecrement()	当前值减1，返回旧值
    public final int getAndAdd(int delta)	当前值增加delta，返回旧值
    public final int incrementAndGet()	当前值加1，返回新值
    public final int decrementAndGet()	当前值减1，返回新值
    public final int addAndGet(int delta)	当前值增加delta，返回新值

作者：码农一枚
链接：https://www.jianshu.com/p/9ff426a784ad
來源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

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
