package com.wangxuebing.thread.pool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author ${Administrator}
 * @description 用spring的綫程池去執行任務也是可以的
 * @create 2018-08-28 9:38
 **/
public class springThreadPool {

    public static void main(String[] args) {

        //spring的创建线程池方式
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        /*
            这个值很重要会影响下面的setRejectedExecutionHandler的线程执行策略，
           因为这个值源码内部是LinkedBlockingQueue的初始化大小，而这个线程执行策略
           又是根据LinkedBlockingQueue来调整系统处理的任务是否过多，以及将怎么处理这些任务
           一共有四种策略，但是最常用的应该就是CallerRunsPolicy 在当前线程池执行的主线程中执行多出来的任务，其他策略基本都是报异常或者直接不执行
           所以这个值非常重要，如果知道任务的数量，最好设成任务数量的大小+1或者+2

           keepAliveTime和maximumPoolSize及BlockingQueue的类型均有关系。
           如果BlockingQueue是无界的，那么永远不会触发maximumPoolSize，自然keepAliveTime也就没有了意义。
           所以这几个值不能乱写，要根据实际情况来定
         */
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setKeepAliveSeconds(100);
        taskExecutor.setMaxPoolSize(200);
        taskExecutor.setKeepAliveSeconds(1000);
        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());


        //submit是带返回值的执行线程，而execute则是无返回值
        for (int i = 0; i < 10; i++){
            int index = i;
            taskExecutor.submit(()->{
                System.out.println("i:" + index + " taskExecutor");
            });
        }
        taskExecutor.shutdown();


        //2使用java原生的创建方式
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.submit(() -> System.out.println("i:" + index + " executorService"));
        }
        executorService.shutdown();

    }
}
