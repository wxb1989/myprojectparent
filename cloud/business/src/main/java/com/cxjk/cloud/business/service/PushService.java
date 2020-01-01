package com.cxjk.cloud.business.service;

import org.springframework.stereotype.Service;

/**
 *.
 * Desc:模拟真正实现推送功能的底层类
 * @author l2h
 */
@Service
public class PushService {
    public void pushMsg(String msg){
        System.out.println(msg);
    }
}
