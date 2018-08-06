package com.wangxuebing.design.demoone.bridge;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 15:37
 *
 **/
public abstract class HandsetBrand {

    protected HandsetSoft handsetSoft;

    public HandsetBrand(HandsetSoft handsetSoft) {
        this.handsetSoft = handsetSoft;
    }

    protected abstract void run();
}
