package com.wangxuebing.design.demoone.decorate.shape;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-26 16:15
 **/
public class TextShapeDecorator extends  ShapeDecorator {

    public TextShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        setTextColor(shape);
    }

    void setTextColor(Shape shape){
        System.out.println("set Text color");
    }
}
