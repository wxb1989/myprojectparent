package com.edison.other;

/**
 * @author ${Administrator}
 * @package com.wangxuebing.other
 * @description ${DESCRIPTION}
 * @create 2018-11-07 11:54
 **/
public class Persion {
    private String name;
    private double heigh;
    private double width;

    public Persion() {
    }

    public Persion(String name, double heigh, double width) {
        this.name = name;
        this.heigh = heigh;
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeigh() {
        return heigh;
    }

    public void setHeigh(double heigh) {
        this.heigh = heigh;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
