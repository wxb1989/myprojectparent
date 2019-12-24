package com.cxjk.cloud.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author
 * @package com.cxjk.cloud.business.service
 * @description
 * @create 2019-12-24 15:29
 **/
@Service
public class ServiceA {

    @Autowired
    private ServiceB serviceB;

    @Transactional
    public void doSomething(){
        //在A SERVICE中 处理 B service的业务要修改 Transactional的传播方式
        serviceB.insert();
    }

}
