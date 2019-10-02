package com.edison.service;

import org.springframework.util.StringUtils;

/**
 * @author
 * @package com.edison.service
 * @description
 * @create 2019-09-18 14:40
 **/
public class StarterService {
    private String config;

    public StarterService(String config) {
        this.config = config;
    }

    public String[] split(String separatorChar) {
        return StringUtils.split(this.config, separatorChar);
    }
}
