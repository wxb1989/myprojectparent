package com.wangxuebing.design.demoone.chain;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-20 16:26
 **/
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }


    @Override
    protected void write(String message) {
        System.out.println("File:" + message);
    }
}
