package com.edison.design.demoone.chain;


/**
 * @author ${Administrator}
 * @description
 *
 * 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，
 * 直到有一个对象处理它为止。
 * 适用场景：
 * 1、有多个的对象可以处理一个请求，哪个对象处理该请求运行时刻自动确定；
 * 2、在不明确指定接收者的情况下，向多个对象中的一个提交一个请求；
 * 3、处理一个请求的对象集合应被动态指定。
 *
 * @create 2017-10-20 16:18
 **/
public class ChainTest {

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");

    }


    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
}
