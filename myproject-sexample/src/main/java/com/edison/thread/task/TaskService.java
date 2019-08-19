package com.edison.thread.task;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-09 14:20
 **/
public class TaskService {

    /**
     *
     * @param poolSize 线程池大小
     * @return
     */
    public List<List<ObjectBo>> getListObject(Integer poolSize) {

        //查出要处理的数据总数
        int count=28;
        System.out.println("查询出需要执行的任务总数：" + count);
        List<List<ObjectBo>> objsList = new ArrayList<List<ObjectBo>>();

        // 根据线程池大小，划分每批需要执行的条数
        int batchSize = count / poolSize;
        // 是否会有余数
        int remainder = count % poolSize;
        int start = 0;
        for (int i = 0; i < poolSize; i++) {
            // 当前批次列表长度，如果总数与分批数量相除有余数，则将【第余数+1个】列表的长度+1
            int limit = batchSize + ((i < remainder)? 1 : 0);

            // 调用DAO层获取数据
            List<ObjectBo> objs = getObjects(start, limit);

            if(null != objs) {
                objsList.add(objs);
            }
            // 计算下一个列表起始位置
            start += limit;
        }
        return objsList;
    }

    /**
     * [从数据库]分批查询出数据列表
     * @param start
     * @param limit
     * @return 模拟数据
     */

    public List<ObjectBo> getObjects(int start, int limit) {

        List<ObjectBo> list = new ArrayList<ObjectBo>();

        ObjectBo obj = null;

        for (int i = start; i < start + limit; i++) {

            obj = new ObjectBo();

            obj.setName("name" + i);

            obj.setAge(22);
            list.add(obj);
        }
        return list;
    }

    /**
     * 执行具体操作
     *
     * @return
     */
    public boolean doSomething() {
        return true;
    }
}
