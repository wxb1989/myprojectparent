package com.wangxuebing.design.demoone.command;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-23 16:20
 **/
public class Demand implements  Task {

    private Programmer programmer;

    public Demand() {
    }

    public Demand(Programmer programmer) {
        this.programmer = programmer;
    }

    @Override
    public void handle() {
        programmer.handleCommand(1);
    }

    @Override
    public String toString() {
        return "Demand{" +
                "programmer=" + programmer.toString() +
                '}';
    }
}
