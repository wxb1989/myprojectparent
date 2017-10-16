package com.wangxuebing.arithmetic.loadbalance;

import java.util.*;

/**
 * 轮训法则
 *
 * @author Administrator
 * @create 2017-10-16 15:17
 **/
public class RoundRobin {

    private static Integer pos = 0;

    public static String  getServer() {

        Map<String, Integer> serverMap = new HashMap<>(20);
        serverMap.putAll(IpMap.serverWeightMap);

        Set<String> keySet=serverMap.keySet();
        List<String> keyList = new ArrayList<>();
        keyList.addAll(keySet);
        String server ="";

        synchronized (pos){
            if(pos > keySet.size()) {
                pos = 0;
            }
            server = keyList.get(pos);
            pos ++;
        }
        return server;
    }

    public static void main(String[] args) {
        System.out.println(getServer());
    }
}
