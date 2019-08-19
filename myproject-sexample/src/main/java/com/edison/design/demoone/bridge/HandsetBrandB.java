package com.edison.design.demoone.bridge;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 15:45
 **/
public class HandsetBrandB extends  HandsetBrand{

    public HandsetBrandB(HandsetSoft handsetSoft) {
        super(handsetSoft);
    }

    @Override
    public void run() {
        handsetSoft.run();
    }
}
