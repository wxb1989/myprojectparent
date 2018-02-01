package com.wangxuebing.base;

/**
 * @author ${Administrator}
 * @description 两个矩阵相乘
 * @create 2018-02-01 16:30
 **/
public class ArrayDemo {

    public static void main(String[] args) {

        int a[][] = new int[2][3]; //动态初始化一个二维数组
        int b[][] = {{1, 5, 2, 8}, {5, 9, 10, -3}, {2, 7, -5, -18}};//静态初始化 一个二维数组　　
        int c[][] = new int[2][4]; //动态初始化一个二维数组

        //初始化值
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = (i + 1) * (j + 2);
            }
        }


        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                c[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    c[i][j] = a[i][k] * b[k][j];
                }
            }
        }


        System.out.println("*******Matrix C********");//打印Matrix C标记
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++)
                System.out.println(c[i][j] + " ");
            System.out.println();
        }
    }

}
