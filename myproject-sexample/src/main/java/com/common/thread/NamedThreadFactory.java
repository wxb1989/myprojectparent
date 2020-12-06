package com.common.thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wxb
 * @version V1.0
 * @Package com.common.thread
 * @date 2020/5/22 10:37
 */
public class NamedThreadFactory implements ThreadFactory {

    private static final AtomicInteger POOL_COUNT = new AtomicInteger();

    private final AtomicInteger threadCount = new AtomicInteger(1);
    private final ThreadGroup group;
    private final String namePrefix;
    private boolean isDaemon;
    /**
     * 默认的线程名称
     */
    private final static String FIRST_PREFIX = "SOFA-ARK-";

    public NamedThreadFactory(String namePrefix) {
        this(namePrefix, false);
    }

    public NamedThreadFactory(String threadPoolName, boolean isDaemon) {
        SecurityManager sm =System.getSecurityManager();
        group=(sm!=null)?sm.getThreadGroup():Thread.currentThread().getThreadGroup();
        namePrefix=FIRST_PREFIX+threadPoolName+"-"+POOL_COUNT.getAndIncrement()+"-t";
        this.isDaemon=isDaemon;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group,r,namePrefix+threadCount.getAndIncrement(),0);
        t.setDaemon(isDaemon);
        //设置线程优先级
        if(t.getPriority()!= Thread.NORM_PRIORITY){
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
