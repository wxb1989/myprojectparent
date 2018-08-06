package com.wangxuebing.design.demoone.command;

/**
 * @author ${Administrator}
 * @description 具体事项
 * @create 2017-10-23 16:19
 **/
public class Programmer {

    private String name;

    public Programmer() {
    }

    public Programmer(String name) {
        this.name = name;
    }

    public void handleCommand(int commandType){
        switch (commandType){
            case 1:
                System.out.println( name + "处理新需求");
                break;

            case 2:
                System.out.println( name + "处理bug");
                break;
            case 3:
                System.out.println( name + "处理线上问题");
                break;
              default:
                  break;

        }

    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                '}';
    }
}
