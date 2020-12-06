package com.common.thread;

import com.common.utils.ThreadPoolUtils;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 参考SOFA自己实现一个线程池
 *
 * @author wxb
 * @version V1.0
 * @Package com.common.thread
 * @date 2020/5/22 10:24
 */
public class CommonThreadPool {

    /**
     * 核心数量
     *
     * @see ThreadPoolExecutor#corePoolSize
     */
    private int corePoolSize = 10;

    /**
     * 线程池的最大数量
     *
     * @see ThreadPoolExecutor#corePoolSize
     */
    private int maximumPoolSize = 100;

    /**
     * 活着时间
     *
     * @see ThreadPoolExecutor#keepAliveTime
     */
    private int keepAliveTime = 300000;

    /**
     * 队列数量
     *
     * @see ThreadPoolExecutor#getQueue
     */
    private int queueSize = 0;

    /**
     * 线程名称
     *
     * @see ThreadPoolExecutor#threadFactory#threadPoolName
     */
    private String threadPoolName = "CommonProcessor";

    /**
     * @see ThreadPoolExecutor#threadFactory#isDaemon
     */
    private boolean isDaemon = false;

    /**
     * 超时时间
     *
     * @see ThreadPoolExecutor#allowCoreThreadTimeOut
     */
    private boolean allowCoreThreadTimeOut = false;

    /**
     * 开启的线程数量
     *
     * @see ThreadPoolExecutor#prestartAllCoreThreads
     */
    private boolean prestartAllCoreThreads = false;

    /**
     * transient他的生命周期在内存中而不会写到磁盘里持久化
     * java 的transient关键字为我们提供了便利，你只需要实现Serilizable接口，
     * 将不需要序列化的属性前添加关键字transient，
     * 序列化对象的时候，这个属性就不会序列化到指定的目的地中。
     * 像银行卡、密码等等这些数据。这个需要根据业务情况了。
     * ThreadPoolExecutor
     */
    transient volatile ThreadPoolExecutor executor;


    public int getCorePoolSize() {
        return corePoolSize;
    }

    public CommonThreadPool setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
        return this;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public CommonThreadPool setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
        return this;
    }

    public int getKeepAliveTime() {
        return keepAliveTime;
    }

    public CommonThreadPool setKeepAliveTime(int keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
        return this;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public CommonThreadPool setQueueSize(int queueSize) {
        this.queueSize = queueSize;
        return this;
    }

    public String getThreadPoolName() {
        return threadPoolName;
    }

    public CommonThreadPool setThreadPoolName(String threadPoolName) {
        this.threadPoolName = threadPoolName;
        return this;
    }

    public boolean isDaemon() {
        return isDaemon;
    }

    public CommonThreadPool setDaemon(boolean daemon) {
        isDaemon = daemon;
        return this;
    }

    public boolean isAllowCoreThreadTimeOut() {
        return allowCoreThreadTimeOut;
    }

    public CommonThreadPool setAllowCoreThreadTimeOut(boolean allowCoreThreadTimeOut) {
        this.allowCoreThreadTimeOut = allowCoreThreadTimeOut;
        return this;
    }

    public boolean isPrestartAllCoreThreads() {
        return prestartAllCoreThreads;
    }

    public CommonThreadPool setPrestartAllCoreThreads(boolean prestartAllCoreThreads) {
        this.prestartAllCoreThreads = prestartAllCoreThreads;
        return this;
    }

    public ThreadPoolExecutor getExecutor() {
        if (executor == null) {
            synchronized (this) {
                if (executor == null) {
                    init();
                }
            }
        }
        return executor;
    }

    private void init() {
        executor=new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime, TimeUnit.MILLISECONDS, ThreadPoolUtils.buildQueue(queueSize),new NamedThreadFactory(
                threadPoolName, isDaemon));
        if (allowCoreThreadTimeOut) {
            executor.allowCoreThreadTimeOut(true);
        }
        if (prestartAllCoreThreads) {
            executor.prestartAllCoreThreads();
        }
    }

}
