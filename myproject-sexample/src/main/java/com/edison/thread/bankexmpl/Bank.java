package com.edison.thread.bankexmpl;

import java.util.concurrent.locks.Lock;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 10:50
 **/
public class Bank implements Runnable {

    private Lock lock;

    private Account account;

    public Bank(Account account, Lock lock) {
        this.account = account;
        this.lock = lock;

    }
    @Override
    public void run() {
        if(account.getBalance()==0.0d){
            System.out.println("没钱不能取钱。。。。。。。。。。。。");
            return ;
        }
        lock.lock();
        try {
            System.out.println("开始取钱。。。。。。。。。。。。");
            for (int i = 0; i < 1000; i++) {
                account.delAmount(1);
            }
            System.out.println("结束取钱。。。。。。。。。。。。");
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
