package com.wangxuebing.arithmetic.loadbalance;

import java.util.*;

/**
 * @author Administrator
 */
public class Random {
    public static String  getServer() {

        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap  = new HashMap<>(10);

        serverMap.putAll(IpMap.serverWeightMap);
        Set<String> ketSet=serverMap.keySet();
        List<String> keyList = new ArrayList<>(20);
        keyList.addAll(ketSet);

        java.util.Random random = new java.util.Random();
        int serverPos=random.nextInt(keyList.size());

        return keyList.get(serverPos);
    }


    public static void main(String[] args) {
        System.out.println(getServer());

    }
}
