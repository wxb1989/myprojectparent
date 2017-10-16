package com.wangxuebing.arithmetic;

import org.apache.commons.codec.binary.Base64;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Base64处理
 *
 * @author
 * @create 2017-10-16 16:09
 **/
public class TestBase64 {

    public static void main(String[] args) {
        String str = "Hello World";

        byte[] encodeBase64 =Base64.encodeBase64(str.getBytes());
        System.out.println("RESULT: En  " + new String(encodeBase64));

        encodeBase64=Base64.decodeBase64(encodeBase64);
        System.out.println("RESULT: De  " + new String(encodeBase64));

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.get("");

        //定义一个数组
        Integer[] arr = {1, 3, 66, 4, 78, 55, 9, 4, 3, 99};

        List<Integer> listA = Arrays.asList(arr);
        Set<Integer> set = new HashSet<>(listA);
        List<Integer> listB = new ArrayList<>();
        listB.addAll(set);
        System.err.println("去重:" + listB.iterator().next().toString());

        Collections.sort(listB);
        System.err.println("排序:" + listB.iterator().next().toString());
        Integer[] newArr;
        newArr= (Integer[]) listB.toArray();
        for (Integer integer : newArr) {
            System.out.println(integer.intValue());
        }
        System.out.println(testFinally());
    }

    public static int testFinally() {
        try {
            return 1;
        }finally {
            System.out.println("32353453443534534534534");
//            return 2;
        }


    }
}
