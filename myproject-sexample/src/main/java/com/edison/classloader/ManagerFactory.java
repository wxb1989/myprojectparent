package com.edison.classloader;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author ${Administrator}
 * @description 加载类的工厂
 * @create 2018-03-26 16:18
 **/
public class ManagerFactory {

    //记载类加载信息的map
    private static final  Map<String ,LoadInfo> loadTimeMap = new ConcurrentHashMap<>(10);

    //要加载类的classpath
    private static  final String CLASS_PATH="G:/git/myprojectparent/myproject-sexample/target/classes/";

    //要记载的类
    public static final String CLASS_MANAGER_NAME="com.wangxuebing.classloader.MyManager";


   public static Manager getMamager(String className) throws IOException {
       Manager manager;
       File loadModifyFile = new File(CLASS_PATH+className.replaceAll("\\.","/")+".class");
       long lastModifiedTime = loadModifyFile.lastModified();
       //map中没有这个类，那就加载这个类到jvm
       if(loadTimeMap.get(className)==null){
           //需要重新加载这个类
           loadClass(className,lastModifiedTime);
       }else if(loadTimeMap.get(className).getLoadTime() != lastModifiedTime){
           loadClass(className, lastModifiedTime);
       }
       return loadTimeMap.get(className).getManager();
    }

    private static void loadClass(String className, long lastModifiedTime) {
        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try {
            loadClass = myClassLoader.findClass(className);

            LoadInfo loadInfo = new LoadInfo(myClassLoader,lastModifiedTime);
            Manager manager = (Manager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
            loadInfo.setManager(manager);
            loadTimeMap.put(className,loadInfo);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
