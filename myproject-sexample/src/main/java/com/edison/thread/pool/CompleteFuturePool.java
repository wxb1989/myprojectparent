package com.edison.thread.pool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CompleteFuturePool {
    public static void main(String[] args) {
//        任务列表
        List<Integer> jobList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        int nThreads = 3;
//        工作线程池
        ExecutorService executorService = new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
//        接收每个任务的执行结果
        List<CompletableFuture<String>> completableFutures = new ArrayList<>(jobList.size());

//        任务分派
        for (int i = 0; i < jobList.size(); i++) {

            try {
                Integer jobId = jobList.get(i);

                CompletableFuture<String> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {

                    System.out.println("模拟任务执行，执行任务："+ jobId);
//                    睡几秒
                    return jobId + "任务执行结果";
                }, executorService);
//            保存本次任务执行结果
                completableFutures.add(integerCompletableFuture);
            } catch (Exception e) {
            }

        }

        System.out.println("任务分派结束");

//        等待全部任务执行完毕
        CompletableFuture[] completableFutures1 = new CompletableFuture[completableFutures.size()];
        CompletableFuture<Void> voidCompletableFuture =
                CompletableFuture.allOf(completableFutures.toArray(completableFutures1));
        try {
            voidCompletableFuture.get();
            System.out.println("打印执行结果");
            completableFutures.stream()
                    .forEach(tmp -> {
                        try {
                            System.out.println("执行结果：{}"+ tmp.get());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        /*
12:06:10.158 [pool-1-thread-1] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：1
12:06:10.158 [pool-1-thread-2] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：2
12:06:10.159 [pool-1-thread-3] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：3
12:06:10.158 [main] INFO org.zln.Demo01CompleteFutureMain - 任务分派结束
12:06:15.167 [pool-1-thread-3] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：6
12:06:15.167 [pool-1-thread-2] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：4
12:06:15.167 [pool-1-thread-1] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：5
12:06:20.172 [pool-1-thread-1] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：7
12:06:20.172 [pool-1-thread-3] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：9
12:06:20.172 [pool-1-thread-2] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：8
12:06:25.175 [pool-1-thread-3] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：10
12:06:25.175 [pool-1-thread-1] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：11
12:06:25.175 [pool-1-thread-2] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：12
12:06:30.180 [pool-1-thread-3] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：13
12:06:30.180 [pool-1-thread-1] INFO org.zln.Demo01CompleteFutureMain - 模拟任务执行，执行任务：14
12:06:35.184 [main] INFO org.zln.Demo01CompleteFutureMain - 打印执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：1任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：2任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：3任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：4任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：5任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：6任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：7任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：8任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：9任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：10任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：11任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：12任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：13任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 执行结果：14任务执行结果
12:06:35.189 [main] INFO org.zln.Demo01CompleteFutureMain - 任务执行完毕
         */
    }
}
