package com.wangxuebing.design.demoone.bridge;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 15:45
 *
 * 桥梁模式虽然不是一个使用频率很高的模式，但是熟悉这个模式对于理解面向对象的设计原则，包括“开-闭”原则以及组合/聚合复用原则都很有帮助。
 * 理解好这两个原则，有助于形成正确的设计思想和培养良好的设计风格。
 * 桥梁模式的用意是“将抽象化(Abstraction)与实现化(Implementation)脱耦，使得二者可以独立地变化”。这句话很短，
 * 但是第一次读到这句话的人很可能都会思考良久而不解其意。这句话有三个关键词，也就是抽象化、实现化和脱耦。
 * 理解这三个词所代表的概念是理解桥梁模式用意的关键
 *
 *        abstract           interface
 *      HandsetBrand        HandsetSoft
 *
 *
 *  桥梁模式在Java应用中的一个非常典型的例子就是JDBC驱动器。JDBC为所有的关系型数据库提供一个通用的界面。一个应用系统动态地选择一个合适的驱动器，
 * 然后通过驱动器向数据库引擎发出指令。这个过程就是将抽象角色的行为委派给实现角色的过程。
 *
 * 桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。这种类型的设计模式属于结构型模式，它通过提供抽象化和实现化之间的桥接结构，
 * 来实现二者的解耦。
 * 这种模式涉及到一个作为桥接的接口，使得实体类的功能独立于接口实现类。这两种类型的类可被结构化改变而互不影响。
 *
 **/
public class HandsetBrandTest {



    public static void main(String[] args) {
        HandsetBrand handsetBrand = new HandsetBrandA(new HandsetSoftGame());
        handsetBrand.run();

        handsetBrand=new HandsetBrandB(new HandsetSoftVideo());
        handsetBrand.run();
    }

}
