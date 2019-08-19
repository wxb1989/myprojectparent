package com.edison.thread.atomic;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 16:05
 **/
public class TestB implements Runnable {
    private AtomO atomO;


    public TestB(AtomO atomO){
        this.atomO=atomO;
    }

    @Override
    public void run() {
        while (true){
            atomO.getAndSet(atomO.getNextValue());
            System.out.println("TestB-----------当前的值"+atomO.getValue());
            atomO.setNo(atomO.getValue());
            System.out.println("TestB ----setNo-----------当前的值"+atomO.getNo());
            if(atomO.getValue()==100){
                System.out.println("TestB-------------当前的值到100了");
                return;
            }
        }
    }
}
