package com.wangxuebing.design.demoone.command;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-23 16:24
 **/
public class Bug implements  Task {

    private Programmer programmer;

    public Bug() {
    }

    public Bug(Programmer programmer) {
        this.programmer = programmer;
    }


    @Override
    public void handle() {
        programmer.handleCommand(2);
    }

    @Override
    public String toString() {
        return "Bug{" +
                "programmer=" + programmer.toString() +
                '}';
    }
}
