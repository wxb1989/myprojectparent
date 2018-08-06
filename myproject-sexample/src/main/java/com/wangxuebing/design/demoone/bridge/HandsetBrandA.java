package com.wangxuebing.design.demoone.bridge;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 15:43
 **/
public class HandsetBrandA extends HandsetBrand{


    public HandsetBrandA(HandsetSoft handsetSoft) {
        super(handsetSoft);
    }

    @Override
    public void run() {
        handsetSoft.run();
    }
}
