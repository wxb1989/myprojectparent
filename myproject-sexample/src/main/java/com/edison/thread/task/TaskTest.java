package com.edison.thread.task;

import java.util.Map;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 14:43
 **/
public class TaskTest {

    public static void main(String[] args) {
        BatchTask batchTask = new BatchTask();
        int poolSize = 1000;
        String result = "";
        Map<String, Integer> map = batchTask.doTask(poolSize);
        result= batchTask.getResultString(map);
    }
}
