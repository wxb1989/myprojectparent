package com.wangxuebing.annotation;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * @author Administrator
 */
public class AnnotationTest implements Serializable {

    private static final long serialVersionUID = -3210031379297872082L;



    public static void main(String[] args) {
        try {
            Description description;
            Class c = Class.forName("com.wangxuebing.annotation.People");

            boolean present  = c.isAnnotationPresent(Description.class);

            if(present){
                description = (Description) c.getAnnotation(Description.class);
                printAnnotationValue(description);
            }

            /**
             * 得到类中的所有属性集合
             */
            People p = new People();
            p.setName("wwwww");
            p.setAge(29);
            Field[] fs = c.getDeclaredFields();
            for(int i = 0 ; i < fs.length; i++){
                Field f = fs[i];
                f.setAccessible(true); //设置些属性是可以访问的
                Object val = f.get(p);//得到此属性的值

                System.out.println("name:"+f.getName()+"\t value = "+val);

                String type = f.getType().toString();//得到此属性的类型
                if (type.endsWith("String")) {
                    System.out.println(f.getType()+"\t是String");
                    f.set(p,"wang") ;        //给属性设值
                    System.out.println("修改以后的值 ： name:"+p.getName());
                }else if(type.endsWith("int") || type.endsWith("Integer")){
                    System.out.println(f.getType()+"\t是int");
                    f.set(p,12) ;       //给属性设值
                    System.out.println("修改以后的值 ： age:"+p.getAge());
                }
            }


            /**
             * 获取所有方法
             */
            Method[]methods=c.getMethods();
            for (Method method : methods) {
                String methodName=method.getName();
                System.out.println(methodName);
                present = method.isAnnotationPresent(Description.class);
                if (present) {
                    description = method.getAnnotation(Description.class);
                    printAnnotationValue(description);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void printAnnotationValue(Description description) {
        System.out.println(description.age());
        System.out.println(description.kind());
        String[] names = description.name();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
