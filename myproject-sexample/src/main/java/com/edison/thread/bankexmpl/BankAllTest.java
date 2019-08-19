package com.edison.thread.bankexmpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 10:53
 **/
public class BankAllTest {

    public static void main(String[] args) {

        Account account = new Account();

        Company company = new Company(account, new ReentrantLock());

        Bank bank = new Bank(account, new ReentrantLock());

        ExecutorService executors = Executors.newFixedThreadPool(1000);

        executors.submit(company);


    }
}
