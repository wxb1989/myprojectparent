package com.edison.design.demoone.chain.example;

import java.util.Date;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-20 16:47
 **/
public class RequestTest {
    public static void main(String[] args) {

        Manager manager =getRequestManager();

        Request request1 = new Request("请假", "小唐请假", 7, new Date());
        manager.requestApplication(request1);

        Request request2 = new Request("加薪", "小唐加薪", 1000, new Date());
        manager.requestApplication(request2);

    }

    private static Manager getRequestManager() {
        Manager commManager = new CommonManager("经理");
        Manager generalManager = new GeneralManager("人事总经理");
        Manager boss =new Boss("大老板");

        commManager.setSuperior(generalManager);
        generalManager.setSuperior(boss);
        return commManager;
    }
}
