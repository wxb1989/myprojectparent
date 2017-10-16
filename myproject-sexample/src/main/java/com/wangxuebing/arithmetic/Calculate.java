package com.wangxuebing.arithmetic;

import java.math.BigDecimal;

/**
 * BigDecimal
 *
 * @author  Administrator
 * @create 2017-10-16 16:04
 **/
public class Calculate {

    public static void main(String[] args) {
        BigDecimal old = new BigDecimal(8030.86);
        BigDecimal newNum = new BigDecimal(8030.86000);
        System.out.println(old.equals(newNum));
    }
}
