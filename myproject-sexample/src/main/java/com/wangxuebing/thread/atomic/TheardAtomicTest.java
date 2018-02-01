package com.wangxuebing.thread.atomic;

/**
 * @author ${Administrator}
 * @description 关于atomic的使用还存在一些问题
 * @create 2017-11-09 16:02
 **/
public class TheardAtomicTest {

    public static void main(String[] args) {
        AtomO atomO = new AtomO();
        try {
            for (int i = 0; i < 2; i++) {
             new Thread( new TestA(atomO)).start();
            }

            for (int i = 0; i < 2; i++) {
                new Thread( new TestB(atomO)).start();
            }
            Thread.sleep(1000);
            System.out.println("Thread sleep ");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
        }

    }

}
