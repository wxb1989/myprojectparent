package com.edison.dtproxy.beand;

public class Boss  implements  IBuilder{


    @Override
    public void buildHouse(){
        System.out.println("Boss 执行 了 buildHouse");
    }
}
