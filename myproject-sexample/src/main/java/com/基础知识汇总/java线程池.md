java线程池
1. 简介
2. 线程池核心参数
3. 任务添加逻辑
4. 线程池里面的ctl对象
5. 线程池的状态及转换
6. 线程池的关闭
7. 如何释放多余工作线程(Worker)
8. 常见线程池
9. 拒绝策略
10. 阻塞队列类型
11. 线程数的选择
1. 简介
什么是线程池: 线程池是一个对象，里面维护这一个队列和诸多工作线程，多线程相互协作处理队列任务，提高系统执行效率。

为什么要用线程池:

减少了创建和销毁线程的次数，每个线程都可以复用
可以根据实际情况，动态调整线程数量、队列长度、丢弃策略等参数，维护系统稳定。
2. 线程池核心参数
这里直接看下线程池的核心构造函数就能知道了

 public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {
        //跳过一些参数检查...
        //1.核心线程数, 当线程池空闲的时候，也不会释放，除非 allowCoreThreadTimeOut = true
        this.corePoolSize = corePoolSize;
        //2.最大线程数,实际能达到的最大值，受机器性能影响
        this.maximumPoolSize = maximumPoolSize;
        //3.任务队列, 存放任务，最终由worker来取走
        this.workQueue = workQueue;
        //4.keepAliveTime, 如有有超过核心线程的多余线程，空闲时间大于 keepAliveTime 会被回收
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        //5.线程工厂，所有线程都是通过这个Factory创建出来的
        this.threadFactory = threadFactory;
        //6.当线程池饱和或正在停止时，新增任务失败，会触发拒绝策略
        this.handler = handler;
    }
3. 任务添加逻辑
如果 工作线程数 < corePoolSize，则创建线程(worker)，并且将当前提交的runnable任务作为第一个任务放到新创建的worker里面。

如果 核心线程数 = corePoolSize， 但是 workQueue还有空间的话， 任务提交到 workQueue 等待执行(这里进行了一个dubbo-check，防止添加进去后，线程刚好释放导致任务不执行)

如果 核心线程数 = corePoolSize, 并且workQueue已满，这时如果worker的数量 < maximumPoolSize, 创建新的线程来执行当前任务

4.上面都不满足, 执行拒绝策略(默认是直接丢弃)!
![Image text](https://box.kancloud.cn/a2e0b181bb1e7681417a3dc547f45b18_1341x615.png)



4. 线程池里面的ctl对象
线程池里面使用一个对象(ctl)来控制着两个核心参数: 有效线程数(workerCount) 和 线程池运行状态(runState)

主要是采用高三位存储线程状态,低29位存储线程数量。

源代码里面是这样定义线程池状态的:

// runState is stored in the high-order bits
private static final int RUNNING    = -1 << COUNT_BITS; //11100000000000000000000000000000
private static final int SHUTDOWN   =  0 << COUNT_BITS; //00000000000000000000000000000000
private static final int STOP       =  1 << COUNT_BITS; //00100000000000000000000000000000
private static final int TIDYING    =  2 << COUNT_BITS; //01000000000000000000000000000000
private static final int TERMINATED =  3 << COUNT_BITS; //01100000000000000000000000000000
假设当前线程池处于运行状态并且线程数为5，那么

ctl = RUNNING | 5(二进制为101) = 11100000000000000000000000000101

//根据ctl求有效线程数
workerCount = ctl & 000111111111111111111111111111111 = 101(10进制为5)

//根据ctl求线程池状态
runState = ctl & 1110000000000000000000000000000000 = 11100000000000000000000000000000(RUNNING)
5. 线程池的状态及转换
从源码来看，线程池有如下5种状态:

RUNNING: 运行中状态,接受新任务并处理队列中的任务

SHUTDOWN: 关闭状态, 不接受新任务, 但是会处理队列中的问题

STOP: 停止状态, 不接收新任务, 不处理队列中的任务,并且会中断正在处理中的任务

TIDYING: 整理状态, 所有任务都已终结，workerCount变为0, 转成 TIDYING 状态会触发 terminated() 回调

TERMINATED: 结束状态，terminated() 执行完成 会变成 TERMINATED状态
![Image text](https://box.kancloud.cn/14f24aecf89199854775df44437fca17_823x375.png)


6. 线程池的关闭
shutdown：当我们调用shutdown后，线程池将不再接受新的任务，但也不会去强制终止已经提交或者正在执行中的任务。

shutdownNow：对正在执行的任务全部发出interrupt()，停止执行，对还未开始执行的任务全部取消，并且返回还没开始的任务列表。

private void interruptWorkers() {
    final ReentrantLock mainLock = this.mainLock;
    mainLock.lock();
    try {
        for (Worker w : workers)
            w.interruptIfStarted();
    } finally {
        mainLock.unlock();
    }
}
void interruptIfStarted() {
    Thread t;
    if (getState() >= 0 && (t = thread) != null && !t.isInterrupted()) {
        try {
            t.interrupt();
        } catch (SecurityException ignore) {
        }
    }
}
7. 如何释放多余工作线程(Worker)
每个worker都是一个Runnable对象,创建后会循环去调用 getTask方法, getTask方法返回一个Runnable任务。拿到任务后直接调用任务的run方法来执行任务。

如果在指定时间(keepAliveTime)没有拿到任务(workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS)), 并且当前任务是可释放的， 那么 getTask会得到一个返回值 null

worker拿到null后(getTask直接返回了null), 通过调用 processWorkerExit 方法，释放掉自己

final void runWorker(ThreadPoolExecutor.Worker w) {
        Thread wt = Thread.currentThread();
        //1.新建worker的时候会有firstTask
        Runnable task = w.firstTask;
        w.firstTask = null;
        w.unlock(); // allow interrupts
        boolean completedAbruptly = true;
        try {

            //2. 第一次会执行firstTask, 以后的轮询都是直接获取任务, 只要能获取到任务,就会一直执行下去
            while (task != null || (task = getTask()) != null) {
                w.lock();
                // If pool is stopping, ensure thread is interrupted;
                // if not, ensure thread is not interrupted.  This
                // requires a recheck in second case to deal with
                // shutdownNow race while clearing interrupt
                if ((runStateAtLeast(ctl.get(), STOP) ||
                        (Thread.interrupted() &&
                                runStateAtLeast(ctl.get(), STOP))) &&
                        !wt.isInterrupted())
                    wt.interrupt();
                try {
                    beforeExecute(wt, task);
                    Throwable thrown = null;
                    try {
                        //每个任务都是一个runnable, 直接调用它的run方法即可
                        task.run();
                    } catch (RuntimeException x) {
                        thrown = x; throw x;
                    } catch (Error x) {
                        thrown = x; throw x;
                    } catch (Throwable x) {
                        thrown = x; throw new Error(x);
                    } finally {
                        afterExecute(task, thrown);
                    }
                } finally {
                    task = null;
                    w.completedTasks++;
                    w.unlock();
                }
            }
            completedAbruptly = false;
        } finally {
            //3.释放当前worker
            processWorkerExit(w, completedAbruptly);
        }
    }
private Runnable getTask() {
        boolean timedOut = false; // Did the last poll() time out?

        for (;;) {
            int c = ctl.get();
            int rs = runStateOf(c);

            // Check if queue empty only if necessary.
            if (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty())) {
                decrementWorkerCount();
                return null;
            }

            int wc = workerCountOf(c);

            // 如果allowCoreThreadTimeOut = false 并且核心线程数未达到，则不需要清理线程
            boolean timed = allowCoreThreadTimeOut || wc > corePoolSize;
            // 如果上一个轮询没有获取到任务 timedOut = true, 那么会不停的尝试减少线程数，具体的释放是在worker里面，这里只是减少数量
            if ((wc > maximumPoolSize || (timed && timedOut))
                    && (wc > 1 || workQueue.isEmpty())) {
                if (compareAndDecrementWorkerCount(c))//线程数减少成功，返回null 通知worker释放掉自己
                    return null;
                continue;
            }

            try {
                Runnable r = timed ?
                        //如果超过 keepAliveTime 拿不到任务, 则认为该线程是空闲状态,应该被释放掉
                        workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) :
                        workQueue.take();
                if (r != null)
                    return r;
                // 只有在当前可以释放线程同时等待时间超过 keepAliveTime 才会达到这一步
                timedOut = true;
            } catch (InterruptedException retry) {
                // 如果线程是被中断的， 会在下次轮询的时候根据线程的状态来退出
                timedOut = false;
            }
        }
    }
8. 常见线程池
java通过Executors 提供四种线程池,分别为:

newCachedThreadPool(推荐使用)
队列没有线程数大小的限制(最大可以达到 2^29-1), 不会存放任务到队列，每来一个新任务，如果没有可用线程(worker)，直接会创建一个新的线程来执行。 因为核心线程数为0，所以空闲的线程会在60秒闲置后自动回收

底层实现:
new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
newFixedThreadPool
核心线程数固定，队列长度没有限制

底层实现:
new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
newScheduledThreadPool
定时执行的线程池

底层实现:
new ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,new DelayedWorkQueue());
newSingleThreadExecutor
单线程线程池，无限容量

new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>()));
9. 拒绝策略
CallerRunsPolicy: 当队列满时，启用调用主线程来完成任务, 可以配合指定长度队列来实现阻塞线程池
public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
    if (!e.isShutdown()) {
        // 直接在主线程执行了 r.run()
        r.run();
    }
}
AbortPolicy: 默认策略, 直接抛异常,任务中断
public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
    //直接抛出异常
    throw new RejectedExecutionException("Task " + r.toString() +
                                         " rejected from " +
                                         e.toString());
}
DiscardPolicy: 直接丢弃
public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
    //里面就是什么也没有
}
DiscardOldestPolicy: 丢弃存在于队列最早的任务
public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
    if (!e.isShutdown()) {
        //抛出最早的一个
        e.getQueue().poll();
        e.execute(r);
    }
}
可以直接new ThreadPoolExecutor.CallerRunsPolicy() 来使用某个策略

10. 阻塞队列类型
LinkedBlockingQueue: 无界队列,超出的任务会放到队列里等待执行

SynchronousQueue: 同步队列,直接将任务交给线程处理，不会堆积到队列中

ArrayBlockingQueue: 有界队列, 超出的任务会根据情况判断创建新线程处理还是丢弃

11. 线程数的选择
如果任务是IO密集型，一般线程数需要设置2倍CPU数以上，以此来尽量利用CPU资源。
如果任务是CPU密集型， 一般线程数量只需要设置成CPU数加1即可，更多的线程数也只能增加上下文切换，不能增加CPU利用率。