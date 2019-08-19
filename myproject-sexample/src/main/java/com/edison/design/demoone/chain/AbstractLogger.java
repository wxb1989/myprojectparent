package com.edison.design.demoone.chain;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-20 16:12
 **/
public abstract class AbstractLogger {

    public static int INFO = 1;

    public static int DEBUG = 2;

    public static int ERROR = 3;

    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    protected abstract void write(String message);

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if(this.level<= level){
            write(message);
        }
        if(nextLogger !=null){
            nextLogger.logMessage(level,message);
        }
    }
}
