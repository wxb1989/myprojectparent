package com.spring.postprocessor.service.impl;

import com.spring.postprocessor.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wangxuebin
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public int login() {
        System.out.println("执行了这个login方法");
        return 0;
    }
}
