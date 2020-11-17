package com.common.log;

import org.slf4j.LoggerFactory;

/**
 * @author wxb
 * @version V1.0
 * @Package com.common.log
 * @date 2020/5/22 10:15
 */
public class ArkLoggerFactory {

    public static ArkLogger getLogger(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        return new ArkLogger(LoggerFactory.getLogger(clazz));
    }
}
