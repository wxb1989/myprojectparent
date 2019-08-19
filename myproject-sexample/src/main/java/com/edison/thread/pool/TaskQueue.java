package com.edison.thread.pool;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author ${Administrator}
 * @description 任务队列
 * @create 2017-11-16 16:10
 **/
public class TaskQueue {

    private int maxSize;
    private Queue<Request> tasks = new ConcurrentLinkedQueue();

    public TaskQueue(int maxSize) {
        this.maxSize = maxSize;
    }

   public void addTask(Request request){
        synchronized (this){
            while (tasks.size() >= maxSize){
                try {
                    System.err.println("任务队列已经满了。。。。。");
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.err.println("添加新任务到任务队列中。。。。");
            tasks.add(request);
            this.notifyAll();
        }
    }
    public Request getTask(){

       synchronized (this){
           while (tasks.size()==0){
               try {
                   System.err.println("任务队列空了。。。。。");
                   this.wait();
               } catch (InterruptedException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               }
           }
           Request request =tasks.poll();
           this.notifyAll();
           return request;
       }

    }
}
