package com.edison.thread.pool;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-16 15:57
 **/
public class HttpRequest implements Request {

    private String name;


    public HttpRequest(String name) {
        super();
        this.name = name;
    }
    @Override
    public void execute() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println(Thread.currentThread().getName() + " 我执行了" + name + ".....");
    }
}
