package com.wangxuebing.collection;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-17 14:07
 **/
public class Paper implements  Cloneable{

    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Paper() {
        flag = "success";
        System.out.println("construction Paper>>>>>>>>>>>>>>>>>>>");
    }

    public void usePaper() {
        System.out.println("使用纸张>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
