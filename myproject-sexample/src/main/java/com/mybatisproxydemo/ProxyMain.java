package com.mybatisproxydemo;

import com.mybatisproxydemo.mapper.UserMapper;
import com.mybatisproxydemo.proxy.MapperProxyFactory;
import com.spring.annotation.configuration.User;

/**
 * @author wxb
 * @version V1.0
 * @Package com.mybatisproxydemo
 * @date 2020/5/8 16:07
 */
public class ProxyMain {
    public static void main(String[] args) {
        MapperProxyFactory<UserMapper> mapperProxyFactory = new MapperProxyFactory(UserMapper.class);
        UserMapper userMapper =  mapperProxyFactory.newInstance();
        userMapper.insertUser("select ");
        userMapper.updateUser("update");

    }
}
