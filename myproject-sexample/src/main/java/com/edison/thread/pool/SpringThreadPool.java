package com.edison.thread.pool;

import java.util.concurrent.*;

/**
 * @author ${Administrator}
 * @description 用spring的綫程池去執行任務也是可以的
 * @create 2018-08-28 9:38
 **/
public class SpringThreadPool {

    public static void main(String[] args) {
        final long waitTime = 8 * 1000;
        final long awaitTime = 60 * 1000;


    /*    //spring的创建线程池方式
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        *//*
            这个值很重要会影响下面的setRejectedExecutionHandler的线程执行策略，
           因为这个值源码内部是LinkedBlockingQueue的初始化大小，而这个线程执行策略
           又是根据LinkedBlockingQueue来调整系统处理的任务是否过多，以及将怎么处理这些任务
           一共有四种策略，但是最常用的应该就是CallerRunsPolicy 在当前线程池执行的主线程中执行多出来的任务，其他策略基本都是报异常或者直接不执行
           所以这个值非常重要，如果知道任务的数量，最好设成任务数量的大小+1或者+2

           keepAliveTime和maximumPoolSize及BlockingQueue的类型均有关系。
           如果BlockingQueue是无界的，那么永远不会触发maximumPoolSize，自然keepAliveTime也就没有了意义。
           所以这几个值不能乱写，要根据实际情况来定
         *//*
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setKeepAliveSeconds(100);
        taskExecutor.setMaxPoolSize(200);
        taskExecutor.setKeepAliveSeconds(1000);
        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());


        //submit是带返回值的执行线程，而execute则是无返回值，而且execute如果有运行错误会抛出异常，
        // 但是submit不用返回值去接收 则不会抛出异常
        for (int i = 0; i < 10; i++){
            int index = i;
            taskExecutor.execute(()->{
                System.out.println("i:" + index + " taskExecutor");
            });
        }
        taskExecutor.shutdown();*/

        /*
        2使用java原生的创建方式
        cpu 密集型任务 java原生ThreadPoolExecutor其实是cpu密集型任务
        io 密集型任务  tomcat和netty拓展的ThreadPool是io型密集任务
        上述扩展方 法虽然看起不是很难，但是自己实现代价可能就比较大。若不想扩展线程池运行 io 密集型任务，
        可以采用下面这种折衷方法。
        过使用这种方式将会使 keepAliveTime 失效，线程一旦被创建，将会一直存在，比较浪费系统资源。
        ThreadPoolExecutor执行流程
                                     execute
                                       ||
        新建线程执行任务<--是<--线程数是否大于corePoolSize
               |                      ||否
               |                  工作队列是否满->是——>线程数量是否大于maxPoolSize--否-->新建线程执行任务
               |                       || 否                 || 是                        ||
               |                   将任务放入队列中          执行拒绝策略                    ||
               |                       ||                    ||                           ||
               |                       ||                    ||                           ||
               |                       ||                    ||                           ||
               |                       ||                    ||                           ||
               | --------------------> 结束<-------------------------------------------------

        */
        int poolSize=Runtime.getRuntime().availableProcessors()*2;

        ExecutorService executorService = new ThreadPoolExecutor(10, poolSize, 0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.execute(() -> System.out.println("i:" + index + " executorService"));
        }

        try {
            // 正确的停止线程方法 而不是暴力的shutdown 因为有可能线程还没执行完毕，
            // 也可以使用CountDownLatch来监控所有线程是不是都执行完了，那就可以直接用shutdown
            executorService.shutdown();

            // 向学生传达“XX分之内解答不完的问题全部带回去作为课后作业！”后老师等待学生答题
            // (所有的任务都结束的时候，返回TRUE)
            if(!executorService.awaitTermination(awaitTime, TimeUnit.MILLISECONDS)){
                // 超时的时候向线程池中所有的线程发出中断(interrupted)。
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            // awaitTermination方法被中断的时候也中止线程池中全部的线程的执行。
            System.out.println("awaitTermination interrupted: " + e);
            executorService.shutdownNow();
        }

    }
}
