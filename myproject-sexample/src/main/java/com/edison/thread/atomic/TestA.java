package com.edison.thread.atomic;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 16:05
 **/
public class TestA implements Runnable {
    private AtomO atomO;


    public TestA(AtomO atomO){
        this.atomO=atomO;
    }

    @Override
    public void run() {
        while (true){
            atomO.getAndSet(atomO.getPreviousValue());
            int value =atomO.getValue() ;
            System.out.println("TestA--------set当前的值"+value);
            atomO.setNo(value);
            if(atomO.getValue()==100){
                System.out.println("TestA----------当前的值到100了");
                return;
            }
        }
    }
}
