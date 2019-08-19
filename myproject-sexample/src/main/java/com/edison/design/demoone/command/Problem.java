package com.edison.design.demoone.command;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-23 16:28
 **/
public class Problem implements Task{
    private Programmer programmer;

    public Problem() {
    }

    public Problem(Programmer programmer) {
        this.programmer = programmer;
    }

    @Override
    public void handle() {
        programmer.handleCommand(3);
    }

    @Override
    public String toString() {
        return "Problem{" +
                "programmer=" + programmer.toString() +
                '}';
    }
}
