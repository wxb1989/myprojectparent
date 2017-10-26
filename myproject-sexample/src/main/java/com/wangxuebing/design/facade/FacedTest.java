package com.wangxuebing.design.facade;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-26 16:32
 * 外观模式比较简单就是暴露给客户端方法，不用知道里面具体实现是什么
 **/
public class FacedTest {
    public static void main(String[] args) {
        ShapeMarker shapeMarker = new ShapeMarker();
        shapeMarker.drawCircle();
        shapeMarker.drawRectangle();
        shapeMarker.drawSquare();
    }
}
