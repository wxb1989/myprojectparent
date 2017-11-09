package com.wangxuebing.thread.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 14:35
 **/
public class BatchTask {

    /**
     * 创建线程池，批量执行任务
     * @param poolSize
     * @return
     */
    public Map<String, Integer> doTask(Integer poolSize) {
        TaskService taskService = new TaskService();
        List<List<ObjectBo>>  list=taskService.getListObject(poolSize);

        ExecutorService pool = Executors.newFixedThreadPool(poolSize);

        // 创建多个有返回值的任务
        List<Future<Map<String, Integer>>> futures = new ArrayList<Future<Map<String, Integer>>>();

        for (int i = 0; i < poolSize; i++) {
            Callable<?> c = new TaskCallable(taskService,  list.get(i), i);
            Future<Map<String, Integer>> f = (Future<Map<String, Integer>>) pool.submit(c);
            futures.add(f);
        }
        if(null != pool){
            pool.shutdown();
        }

        // 执行状态汇总
        int total = 0;// 总数
        int success = 0;// 成功数
        int failedDB = 0;// 数据库操作失败数
        int otherSys = 0;// 其它系统返回错误数
        int successThread = poolSize;// 成功的线程数量

        for (Future<Map<String, Integer>> future : futures) {
            Map<String, Integer> result = null;
            try {
                result = (Map<String, Integer>) future.get();
            } catch (InterruptedException | ExecutionException e) {// JRE1.7+支持这种写法
                successThread--;
                continue;
            }

            // 合并任务返回的结果
            if (result != null) {
                total += result.get("total");
                success += result.get("success");
                failedDB += result.get("failedDB");
                otherSys += result.get("otherSys");
            } else {
                System.out.println("任务返回结果为空，可能是传入卡列表对象为空");
            }
        }

        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put("total", total);
        resultMap.put("success", success);
        resultMap.put("failedDB", failedDB);
        resultMap.put("otherSys", otherSys);
        resultMap.put("taskSize", poolSize);
        resultMap.put("successThread", successThread);
        return resultMap;

    }

    /**
     78
     * 执行任务状态返回值
     79
     *
     80
     * @param resultMap
    81
     * @return
    82
     */
    public String getResultString(Map<String, Integer> resultMap) {
        int total = resultMap.get("total");// 总数
        int success = resultMap.get("success");// 执行成功数
        int failedDB = resultMap.get("failedDB");// 数据库执行失败数
        int taskSize = resultMap.get("taskSize");// 任务总数
        int otherSys = resultMap.get("otherSys");// 其它系统返回错误
        int successThread = resultMap.get("successThread");

        String result =
        "线程执行状态(成功/总数)：" + successThread + "/" + taskSize
                + "\n总数："   + total
                + "\n成功：" + success
                + "\nDB失败：" + failedDB
                + "\n外系统失败：" + otherSys
                + "\n未明：" + (total - success - failedDB - otherSys);
        return result;
    }


}

