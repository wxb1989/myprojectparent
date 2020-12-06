package com.common.utils;

import java.util.concurrent.*;

/**
 * @author wxb
 * @version V1.0
 * @Package com.common.utils
 * @date 2020/5/22 10:46
 */
public class ThreadPoolUtils {


    /**
     * Build Queue
     *
     * @param size       size of queue
     * @param isPriority whether use priority queue or not
     * @return queue
     */
    public static BlockingQueue<Runnable> buildQueue(int size, boolean isPriority) {
        BlockingQueue<Runnable> queue = null;
        if (size == 0) {
            queue = new SynchronousQueue<>();
        } else {
            if (isPriority) {
                queue = size < 0 ? new PriorityBlockingQueue<>() : new PriorityBlockingQueue<>(size);
            } else {
                queue= size<0 ? new LinkedBlockingDeque<>(): new LinkedBlockingDeque<>(size);
            }
        }
        return queue;
    }

    public static BlockingQueue<Runnable> buildQueue(int queueSize) {
        return buildQueue(queueSize,false);
    }
}
