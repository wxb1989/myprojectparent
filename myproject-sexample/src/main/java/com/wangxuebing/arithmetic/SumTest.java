package com.wangxuebing.arithmetic;

import java.io.Serializable;

/**
 * @author ${Administrator}
 * @description 位运算的的一些应用
 * @create 2017-10-17 15:16
 **/
public class SumTest implements Serializable {

    public static void main(String[] args) {
        int calcResult = 10 << 2;
        System.out.println(" 左移 2位 "+calcResult);

        int calcResult2 = 10 >> 2;
        System.out.println(" 右移 2位 "+calcResult2);

        //判断int型变量a是奇数还是偶数
        int a =11;
        if((a & 1) == 0) {
            System.out.println("a 是偶数");
        }
        if((a & 1) == 1) {
            System.out.println("a 是奇数");
        }

        //求平均值，比如有两个int类型变量x、y,首先要求x+y的和，再除以2，但是有可能x+y的结果会超过int的最大表示范围，所以位运算就派上用场啦。
        int x =10 ;
        int y=35;
        int z =(x&y)+((x^y)>>1);
        System.out.println(z);

        //交换数字
        x ^= y;
        y ^= x;
        x ^= y;

        System.out.println(x +"  "  + y);

        /*
            取模运算，采用位运算实现：
            a % (2^n) 等价于 a & (2^n - 1)

            乘法运算 采用位运算实现
            a * (2^n) 等价于 a << n

            除法运算转化成位运算
            a / (2^n) 等价于 a>> n

            求相反数
            (~x+1)

            a % 2 等价于 a & 1
        */

    }
}
