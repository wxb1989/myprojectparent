package com.edison.arithmetic;

/**
 * 递归
 *
 * @author
 * @create 2017-10-16 16:06
 **/
public class Recursion {

    static int  fcn(int i){
        if(i==0){
            return 1;
        }
        System.out.println(i);
        return fcn(i-1);
    }
    public static void main(String[] args) {
        System.out.println(fcn(10));
    }
}
