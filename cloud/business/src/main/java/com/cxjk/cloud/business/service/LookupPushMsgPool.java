package com.cxjk.cloud.business.service;
import org.apache.tomcat.util.threads.TaskQueue;
import org.apache.tomcat.util.threads.TaskThreadFactory;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LookupPushMsgPool {
    /**
     * 线程池
     */
    private ThreadPoolExecutor executorService;
    /**
     * 任务队列
     */
    private TaskQueue taskqueue ;
    /**
     * 最大队列数量.通常配置在配置文件中.这里样例代码不加太多东西．
     * 简单点使用@value注入，复杂点像springboot一样＠Configuration＋＠ConfigurationProperties
     */
    private final int acceptCount = 10000;
    /**
     *核心线程数
     */
    private final int corePoolSize = 20;
    /**
     * 最大线程数
     */
    private final int maxPoolSize = 100;
    /**
     * 线程保活时间
     */
    private final int keepAliveTime =60;
    public LookupPushMsgPool(){
        taskqueue = new TaskQueue(acceptCount);
        TaskThreadFactory tf =  new TaskThreadFactory("simos-pool-msg-",true,Thread.NORM_PRIORITY);
        executorService = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime, TimeUnit.SECONDS,
                taskqueue, tf);
        executorService.setThreadRenewalDelay(org.apache.tomcat.util.threads.Constants.DEFAULT_THREAD_RENEWAL_DELAY);
        taskqueue.setParent(executorService);
    }
    public void pushMsg(String msg){
        if (msg!=null){
            try {
                System.out.println("lookup class:"+this.getClass());
                PushMsgTask task = pushMsgTask(msg);
                executorService.submit(task);
            }

            catch (Exception exception){
                System.out.println("推送失败,失败原因:"+exception.getMessage());
            }

        }
    }
    @Lookup
    protected  PushMsgTask pushMsgTask(String msg){
        return  new PushMsgTask(msg);
    }
}
