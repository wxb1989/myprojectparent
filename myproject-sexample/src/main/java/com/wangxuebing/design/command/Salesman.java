package com.wangxuebing.design.command;

/**
 * @author ${Administrator}
 * @description 客户端的类
 * @create 2017-10-23 16:38
 **/
public class Salesman {

    private String name ;
    private ProductManager productManager;

    public Salesman(String name, ProductManager productManager) {
        super();
        this.name = name;
        this.productManager = productManager;
    }

    public void putDemand(){
        System.out.println( "业务员" + name + "提出新需求");
        productManager.receive(new Demand(productManager.chooseProgrammer()));
    }

    public void putBug(){
        System.out.println( "业务员" + name + "提出新BUG");
        productManager.receive(new Bug(productManager.chooseProgrammer()));
    }

    public void putProblem(){
        System.out.println( "业务员" + name + "提出新问题");
        productManager.receive(new Problem(productManager.chooseProgrammer()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
