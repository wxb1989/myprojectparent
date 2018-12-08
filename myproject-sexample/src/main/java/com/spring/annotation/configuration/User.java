package com.spring.annotation.configuration;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author ${Administrator}
 * @package com.spring.annotation.configuration
 * @description 实现InitializingBean 和 DisposableBean 可以看到bean初始化和销毁操作
 * @create 2018-11-07 15:28
 **/
@Component
public class User implements InitializingBean , DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---------InitializingBean----------");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("---------DisposableBean----------");
    }
}
