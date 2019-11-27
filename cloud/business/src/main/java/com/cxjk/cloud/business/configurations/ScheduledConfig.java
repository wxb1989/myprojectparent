package com.cxjk.cloud.business.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池和定时任务的配置
 * @author sw
 * date 2019-10
 *
 */
@Configuration
public class ScheduledConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setTaskScheduler(this.taskScheduler());
    }

    @Bean(destroyMethod="shutdown")
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(20);
        scheduler.setThreadNamePrefix("task-");
        scheduler.setAwaitTerminationSeconds(0);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.setRemoveOnCancelPolicy(true);
        return scheduler;
    }


    @Bean("asyncTaskExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
        asyncTaskExecutor.setCorePoolSize(4);
        asyncTaskExecutor.setMaxPoolSize(8);
        asyncTaskExecutor.setQueueCapacity(512);//缓冲执行任务的队列
        asyncTaskExecutor.setKeepAliveSeconds(60);//当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
        asyncTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);//线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        asyncTaskExecutor.setAwaitTerminationSeconds(60);//设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住
        asyncTaskExecutor.setThreadNamePrefix("async-executor-thread-");
        asyncTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        asyncTaskExecutor.initialize();
        return asyncTaskExecutor;
    }
}
