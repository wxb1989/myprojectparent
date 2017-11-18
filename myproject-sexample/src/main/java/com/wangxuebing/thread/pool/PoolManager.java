package com.wangxuebing.thread.pool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author ${Administrator}
 * @description 线程池管理
 * @create 2017-11-16 16:12
 **/
public class PoolManager {

    private int maxSize;
    private int maxTaskSize;

    private List<WorkThread> workThreads = new LinkedList();
    private  TaskQueue taskQueue;


    public PoolManager(int maxSize, int maxTaskSize) {
        this.maxSize = maxSize;
        this.maxTaskSize = maxTaskSize;
        this.init();
    }

    private void init() {
        taskQueue = new TaskQueue(maxTaskSize);
        for (int i = 0; i < maxSize; i++) {
            WorkThread workThread = new WorkThread("工作线程"+i,taskQueue);
            workThreads.add(workThread);
        }
    }

    public void start() {
        for (WorkThread workThread : workThreads) {
            workThread.run();
        }
    }


    public void execute(Request request) {
        taskQueue.addTask(request);
    }
}
