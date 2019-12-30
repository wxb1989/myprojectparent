package com.zhh.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 自定义协议的编码器
 */
public class SmartCarEncoder extends MessageToByteEncoder<SmartCarProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, SmartCarProtocol smartCarProtocol, ByteBuf out) throws Exception {
// 写入消息SmartCar的具体内容
        // 1.写入消息的开头的信息标志(int类型)
        out.writeInt(smartCarProtocol.getHead_data());
        // 2.写入消息的长度(int 类型)
        out.writeInt(smartCarProtocol.getContentLength());
        //3.写入协议的具体内容
        out.writeBytes(smartCarProtocol.getContent());
    }
}
