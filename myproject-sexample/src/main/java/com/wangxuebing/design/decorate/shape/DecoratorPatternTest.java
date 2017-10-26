package com.wangxuebing.design.decorate.shape;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-26 16:17
 **/
public class DecoratorPatternTest {

    public static void main(String[] args) {
        Shape shape = new Rectangle();
        Shape  baShape = new BackgroundShapeDecorate(shape);
        Shape  redShapeDecorator = new RedShapeDecorator(baShape);
        shape = new TextShapeDecorator(redShapeDecorator);
        shape.draw();

    }
}
