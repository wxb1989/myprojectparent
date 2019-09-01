package com.spring.postprocessor.service;

import com.spring.postprocessor.annotation.Cmd;
import com.spring.postprocessor.annotation.Model;

/**
 * @authdison
 * UserService 用来做测试的demo
 *
 */
@Model(modelVal = "user")
public interface UserService {

    @Cmd(cmdVal = "login")
    public  int login();

}
