package com.edison.thread.concurrent.example1;


/**
 * @author ${Administrator}
 * @description 用来放线程数据的容器
 * @create 2018-08-28 10:29
 **/
public class ThreadShareData {
    /**
     * ThreadLocal:将变量与当前线程绑定,相当于Map<Thread, value>
     * 此处使用的是饱汉模式构造
     */
    private static ThreadLocal<ThreadShareData> threadLocal = new ThreadLocal<>();
    private String name;
    private int age;

    //防止new,生成单例类
    private ThreadShareData() {
    }

    /**
     * 返回当前线程的单例
     * 此处不需要使用关键字synchronized,想想为什么?
     */
    public static ThreadShareData getCurrentThreadInstance() {
        ThreadShareData threadShareData = threadLocal.get();
        if (threadShareData == null) {
            threadShareData = new ThreadShareData();
            threadLocal.set(threadShareData);
        }
        return threadShareData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
