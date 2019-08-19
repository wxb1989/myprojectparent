package com.edison.suanfatest;

/**
 * @author ${Administrator}
 * @description  一个给定一个二维数组和一个值，要判断这个值是否在二维数组里
 * @create 2018-03-12 10:37
 **/
public class Projecy {

    public static void main(String[] args) {
        int [][] s = { {1,2,3}  ,{4,5,6}  ,{7,8,9} };

        System.out.println(fixNum(s,5));

    }


    public static int fixNum( int[][] srcArray ,int num ){
        int result=-1;

        int i= 0; //其实值
        int j =srcArray[0].length -1 ;//二维数组第二个维度的长度 列

        while (i<srcArray.length && j >=0){
            //查找的元素和当前值相等
            if(num == srcArray[i][j]){
                result=num;
                return result;
            }else{
                //如果num大于行的第一个值就i++
                if(num > srcArray[i][j]){
                    i++;
                }else{
                    //否则就列+1
                    j--;
                }
            }
        }
        return -1;

    }


}
