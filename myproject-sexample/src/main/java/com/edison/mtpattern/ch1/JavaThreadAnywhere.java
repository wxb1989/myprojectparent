package com.edison.mtpattern.ch1;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-06 16:17
 **/
public class JavaThreadAnywhere {

    public static void main(String[] args) {
        System.out.println("The main method was executed by thread:"
                + Thread.currentThread().getName());
        Helper helper = new Helper("Java Thread AnyWhere");
        helper.run();
    }
}

class Helper implements Runnable{

    private final String message;

    public Helper(String message) {
        this.message = message;
    }

    private void doSomething(String message) {
        System.out.println("The doSomething method was executed by thread:"
                + Thread.currentThread().getName());
        System.out.println("Do something with " + message);
    }

    @Override
    public void run() {
        doSomething(message);

    }
}
