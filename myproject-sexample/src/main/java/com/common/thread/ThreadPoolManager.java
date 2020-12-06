package com.common.thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wxb
 * @version V1.0
 * @Package com.common.thread
 * @date 2020/5/22 10:52
 */
public class ThreadPoolManager {
    /**
     * Manager group of {@see CommonThreadPool}
     */
    private static ConcurrentHashMap<String, CommonThreadPool> threadPoolMap = null;

    public static synchronized void registerThreadPool(String threadPoolName, CommonThreadPool commonThreadPool) {
        if (threadPoolMap == null) {
            threadPoolMap = new ConcurrentHashMap<>(16);
        }
        threadPoolMap.putIfAbsent(threadPoolName, commonThreadPool);
    }

    public static synchronized void unRegisterThreadPool(String threadPoolName) {
        if (threadPoolMap != null) {
            threadPoolMap.remove(threadPoolName);
        }
    }

    public static synchronized CommonThreadPool getCommonThreadPool(String threadPoolName) {
        return threadPoolMap == null ? null : threadPoolMap.get(threadPoolName);
    }
}
