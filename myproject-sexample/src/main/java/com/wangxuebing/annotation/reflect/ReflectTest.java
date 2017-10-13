package com.wangxuebing.annotation.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * DB加载器测试自己写的玩的
 */
public class ReflectTest {

    private static final String DB_NAME_KEY = "db_server_name";

    private static final String DB_CONFIG_FILE = "/db.properties";

    public static  void main(String[] args) {
        ReflectTest reflectTest = new ReflectTest();
        String s = "mysql";
        DBServer server;
        server = reflectTest.getDbServerByStatic(s);

        System.out.println(server);
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            server =   reflectTest.getDbServerByDynamic();
            System.out.println(server);
        }
    }

    private DBServer getDbServerByStatic(String s) {
        DBServer server=null;
        switch (s){
            case "oracle":
                break;
            case "mysql":
                server = new MySqlServer();
                break;
        }
        return server;
    }


    public DBServer getDbServerByDynamic() {
        Properties properties = new Properties();
        try {
        InputStream inputStream ;
        String path=this.getClass().getResource(DB_CONFIG_FILE).getPath();

            inputStream = new FileInputStream(path);
            properties.load(inputStream);
            return (DBServer) Class.forName(properties.getProperty(DB_NAME_KEY)).newInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }
}
