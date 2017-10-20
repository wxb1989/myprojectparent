package com.wangxuebing.design.build;

import org.springframework.security.access.method.P;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 16:18
 **/
public class ConcreteProduct implements Product{

    @Override
    public void show() {
        System.out.println("ConcreteProduct");
    }
}
