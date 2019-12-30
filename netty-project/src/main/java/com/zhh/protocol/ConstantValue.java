package com.zhh.protocol;

public class ConstantValue {
    /**
     * 自定义协议头
     */
    public static final int HEAD_DATA = 0x76;

    /**
     * 头+消息长度占的位置
     */
    public static final int BASE_LENGTH = 4 + 4;
    /**
     * 协议的最大长度
     */
    public static final int MAX_LENGTH = 2048;
}
