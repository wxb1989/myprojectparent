package com.wangxuebing.design.facade;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 *  外观模式对外的类
 * @create 2017-10-26 16:27
 **/
public class ShapeMarker {

    private Shape rectangle;

    private Shape circle;

    private Shape square;


    public ShapeMarker() {
        this.rectangle = new Rectangle();
        this.circle = new Circle();
        this.square = new Square();
    }

    public void drawRectangle(){
        rectangle.draw();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawSquare(){
        square.draw();
    }
}
