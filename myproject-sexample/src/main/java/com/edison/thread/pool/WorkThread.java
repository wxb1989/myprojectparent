package com.edison.thread.pool;

/**
 * @author ${Administrator}
 * @description 工作线程
 * @create 2017-11-16 16:11
 **/
public class WorkThread  implements  Runnable{

    private TaskQueue  queue;
    private boolean used = false;

    public boolean isUsed() {
        return used;
    }


    public WorkThread(String name,TaskQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            used = true;
            Request task = queue.getTask();
            task.execute();
            used = false;
        }

    }
}
