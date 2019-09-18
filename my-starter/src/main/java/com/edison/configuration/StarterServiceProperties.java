package com.edison.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangxb
 * @package com.edison.configuration
 * @description 自定义的starter配置文件读取类
 * @create 2019-09-18 14:41
 **/
@ConfigurationProperties("example.service")
public class StarterServiceProperties {
    private String config;

    public void setConfig(String config) {
        this.config = config;
    }

    public String getConfig() {
        return config;
    }
}
