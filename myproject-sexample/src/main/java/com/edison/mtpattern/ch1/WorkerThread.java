package com.edison.mtpattern.ch1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-06 16:22
 **/
public class WorkerThread {

    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.init();

        // 此处，helper的客户端线程为main线程
        helper.submit("Something...");

    }



    /**
     *
     */
    static class Helper {

        private final BlockingQueue<String> workQueue = new ArrayBlockingQueue<String>(100);

        private final Thread workerThread = new Thread(() -> {
            String task;
            while (true) {
                try {
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    break;
                }
                System.out.println(doProcess(task));

            }
        });

        public void init() {
            workerThread.start();
        }

        protected String doProcess(String task) {
            return task + "->processed.";
        }

        public void submit(String task) {
            try {
                workQueue.put(task);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }


    }
}

