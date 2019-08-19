package com.edison.design.demoone.bridge;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 15:39
 **/
public class HandsetSoftVideo implements HandsetSoft {


    @Override
    public void run() {
        //处理业务逻辑
        System.out.println("HandsetSoftVideo");
    }
}
