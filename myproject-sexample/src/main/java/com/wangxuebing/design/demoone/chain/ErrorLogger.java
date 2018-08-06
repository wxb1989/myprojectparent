package com.wangxuebing.design.demoone.chain;


/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-20 16:16
 **/
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }


    @Override
    protected void write(String message) {
        System.out.println("Error:" + message);
    }
}
