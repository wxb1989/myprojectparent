package com.spring.postprocessor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author  edsion
 * 执行器存储-类似于spring的初始化的bean容器
 */
public class InvokerHolder {

    public  static Map<String ,Map<String ,Invoker>> invokers = new ConcurrentHashMap<>();


    /**
     * 添加执行器
     * @param model
     * @param cmd
     * @param invoker
     */
    public static void addInvoker(String model,String cmd,Invoker invoker){
        Map map =invokers.get(model);
        if(map==null ){
            map = new HashMap();
            invokers.put(model,map);
        }
        map.put(cmd,invoker);
    }

    /**
     * 获取执行器
     * @param model
     * @param cmd
     * @return
     */
    public static Invoker getInvoker(String model,String cmd){
        Map<String, Invoker> map = invokers.get(model);
        if(map == null ){
            return null;
        }
        return map.get(cmd);
    }



}
