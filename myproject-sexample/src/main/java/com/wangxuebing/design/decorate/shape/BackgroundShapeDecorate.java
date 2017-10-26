package com.wangxuebing.design.decorate.shape;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-26 16:12
 **/
public class BackgroundShapeDecorate extends ShapeDecorator {

    public BackgroundShapeDecorate(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        setBackground(shape);
    }

    private void setBackground(Shape shape) {
        System.out.println("background:red");
    }
}
