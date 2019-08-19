package com.edison.thread.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 14:25
 **/
public class TaskCallable<V> implements Callable<V> {

    private TaskService service;
    private List<?> list;
    private int curThreadNo;
    private int curNo;


    private AtomicInteger count = new AtomicInteger(1);


    TaskCallable(TaskService service,List<?> list,int curThreadNo){
        this.service=service;
        this.list=list;
        this.curThreadNo=curThreadNo;
    }

    @Override
    public V call() throws Exception {

        System.out.println(">>>第" + curThreadNo + "主线程任务启动");

        Map<String, Integer> resMap = new HashMap();
        if(list !=null){
            resMap = doJobs(list);
        }
        System.out.println(">>>第" + curThreadNo + "主线程任务结束" + count.getAndIncrement());
        System.out.println(">>>第 curNo " + curNo );
        return (V) resMap;
    }

    private Map<String,Integer> doJobs(List<?> list) {
        int total = 0;// 总数
        int success = 0;// 成功数
        int failedDB = 0;// 数据库操作失败数
        int otherSys = 0;// 其它系统返回错误
        total = list.size();
        System.out.println("主线程" + curThreadNo + "待处理数据条数：" + total);

        for (int i = 0; i < total; i++) {
            System.out.println("主线程" + curThreadNo + "进度：" + ((i + 1) * 100 / total) + "%");
            System.out.println("主线程" + curThreadNo + "开始处理第 " + (i + 1) + "/" + total + "条数据");
            count.set(++i);
            curNo+=i;
            // 调用服务执行具体操作
            service.doSomething();
            // 模拟 执行返回状态
            if (i == 1) {
                failedDB++;
            } else if (i == 2) {
                otherSys++;
            } else if (i == 3) {
                try {
                    throw new Exception("Unknow Exception.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                success++;
            }
        }
        Map<String, Integer> resultMap = new HashMap();
        resultMap.put("total", total);
        resultMap.put("success", success);
        resultMap.put("failedDB", failedDB);
        resultMap.put("otherSys", otherSys);
        return resultMap;


    }
}
