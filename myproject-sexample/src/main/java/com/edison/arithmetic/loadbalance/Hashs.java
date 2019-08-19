package com.edison.arithmetic.loadbalance;


import java.util.*;

/**
 * @author Administrator
 * 源地址哈希（Hash）法
 */
public class Hashs {

    public static String  getServer() {

        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap  = new HashMap<>(10);

        serverMap.putAll(IpMap.serverWeightMap);
        Set<String> ketSet=serverMap.keySet();
        List<String> keyList = new ArrayList<>(20);
        keyList.addAll(ketSet);

        // 在Web应用中可通过HttpServlet的getRemoteIp方法获取
        String remoteIp = "196.168.10.196";
        int hashCode = remoteIp.hashCode();
        int serverListSize = keyList.size();
        int serverPos =hashCode%serverListSize;
        return keyList.get(serverPos);
    }


    public static void main(String[] args) {
        System.out.println(getServer());

    }
}
