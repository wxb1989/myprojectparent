package com.wangxuebing.classloader;

import java.io.IOException;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2018-03-26 16:49
 **/
public class MsgHandler implements Runnable {
    @Override
    public void run() {

        while (true){
            try {
                Manager manager= ManagerFactory.getMamager(ManagerFactory.CLASS_MANAGER_NAME);
                manager.logic();
                Thread.sleep(2000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
