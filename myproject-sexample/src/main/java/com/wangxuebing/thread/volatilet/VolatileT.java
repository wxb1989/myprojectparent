package com.wangxuebing.thread.volatilet;

/**
 * Volatile关键字示例
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2018-01-11 15:05
 **/
public class VolatileT {

    private volatile int count =0 ;

    private void setCount(){
        count++;
    }

    private int getCount(){
        return  this.count;
    }

    public static void main(String[] args) {
      final   VolatileT volatileT = new VolatileT();

        for (int i = 0; i <100 ; i++) {
              new  Thread(new Runnable() {
                  @Override
                  public void run() {
                      volatileT.setCount();
                  }
              }).start();

        }

        //而如果还有子线程在运行，主线程让出资源

        while (Thread.activeCount()>1){
            Thread.yield();

        }
        System.out.println(volatileT.getCount());



    }

}
