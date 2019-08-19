package com.edison.thread.bankexmpl;

import java.util.concurrent.locks.Lock;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 10:52
 **/
public class Company implements Runnable {

    private Lock lock;

    private Account account;

    public Company(Account account, Lock lock) {
        this.account = account;
        this.lock = lock;

    }
    @Override
    public void run() {

        lock.lock();
        try {
            System.out.println("开始存钱。。。。。。。。。。。。");
            for (int i = 0; i < 1000; i++) {
                account.addAmount(1);
            }
            System.out.println("结束存钱。。。。。。。。。。。。");
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
