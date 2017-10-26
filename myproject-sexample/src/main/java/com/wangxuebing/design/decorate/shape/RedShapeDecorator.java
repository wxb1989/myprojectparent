package com.wangxuebing.design.decorate.shape;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-26 16:14
 **/
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder(shape);
    }

   void setRedBorder(Shape shape){
       System.out.println("Border Color: Red");
    }
}
