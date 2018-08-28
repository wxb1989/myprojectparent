package com.wangxuebing.thread.pool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author ${Administrator}
 * @description 用spring的綫程池去執行任務也是可以的
 * @create 2018-08-28 9:38
 **/
public class springThreadPool {

    public static void main(String[] args) {


        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setKeepAliveSeconds(100);
        taskExecutor.setMaxPoolSize(200);
        taskExecutor.setKeepAliveSeconds(1000);
        taskExecutor.setAllowCoreThreadTimeOut(true);


    }
}
