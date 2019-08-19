package com.edison.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ${Administrator}
 * @description 实现简单的一个二叉树并遍历
 * @create 2017-10-17 15:46
 **/
public class Node {

    private Node leftNode;
    private Node rightNode;
    private Object value;



    public void add(Object o){
        if(value==null){
            value=o;
        }else{
            if((Integer) o < (Integer)value){
                if(leftNode==null){
                    leftNode = new Node();
                }
                leftNode.add(o);
            }else{
                 if(rightNode==null){
                     rightNode = new Node();
                 }
                rightNode.add(o);
            }
        }
    }
    public List<Object> values() {
        List<Object> values = new ArrayList<>();
        if (null != leftNode) {
            values.addAll(leftNode.values());
        }
        values.add(value);
        if (null != rightNode) {
            values.addAll(rightNode.values());
        }
        return values;
    }

    public static void main(String[] args) {
        int randoms[] = new int[]{67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        Node roots = new Node();
        for (int number : randoms) {
            roots.add(number);
        }
        System.out.println(roots.values());
    }
}
