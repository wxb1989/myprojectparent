package com.edison.collection;

/**
 * @author ${Administrator}
 * @description 工厂创建类
 * @create 2017-10-17 14:09
 **/
public class PaperFactory {

    private Paper paperBese = new Paper();

    public  Paper createPaper() throws CloneNotSupportedException {
        return (Paper) paperBese.clone();
    }
}
