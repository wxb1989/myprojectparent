package com.wangxuebing.classloader;

/**
 * @author ${Administrator}
 * @description 加载类的信息
 * @create 2018-03-26 15:59
 **/
public class LoadInfo {

    //自定义类加载器
    private MyClassLoader myClassLoader;
    //加载类的时间
    private long loadTime;

    Manager manager;

    public LoadInfo(MyClassLoader myClassLoader, long loadTime) {
        this.myClassLoader = myClassLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyClassLoader() {
        return myClassLoader;
    }

    public void setMyClassLoader(MyClassLoader myClassLoader) {
        this.myClassLoader = myClassLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
