package com.edison.classloader;

/**
 * @author ${Administrator}
 * @description 重写父类方法，让classloader可以加载字节码
 * @create 2018-03-26 15:56
 **/
public class MyManager implements  Manager {

    @Override
    public void logic() {

        System.out.println("加载字节码!");
        System.out.println("sssss!");
        System.out.println("aaaaa!");
        System.out.println("ccc!");
        System.out.println("ssssddddd!");
        System.out.println("wwwwwwwwwwww!");
    }
}
