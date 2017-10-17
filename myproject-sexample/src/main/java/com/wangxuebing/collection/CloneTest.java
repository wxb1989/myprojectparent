package com.wangxuebing.collection;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-17 14:06
 **/
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        Paper paper = new Paper();

        Paper clonePaper = (Paper) paper.clone();

        System.out.println(clonePaper.getFlag());

        PaperFactory factory = new PaperFactory();

        Paper papers= factory.createPaper();

        System.out.println(papers.getFlag());
    }
}
