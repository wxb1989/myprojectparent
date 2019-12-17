package com.zhh.tcp;

import io.netty.channel.Channel;

/**
 * @author
 * @package com.zhh.tcp
 * @description
 * @create 2019-12-17 10:17
 **/
public class NettyChannel {

    private String userId;
    private Channel channel;

    public NettyChannel(String userId, Channel channel) {
        this.userId = userId;
        this.channel = channel;
    }

    public String getChannelId() {
        return channel.id().toString();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public boolean isActive() {
        return channel.isActive();
    }
}
