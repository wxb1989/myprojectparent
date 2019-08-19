package com.edison.design.demoone.decorate.shape;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-26 16:10
 **/
public abstract class ShapeDecorator implements Shape{

    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
