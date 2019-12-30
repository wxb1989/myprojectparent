package com.zhh.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * 客户端接收的消息
 */
public class ClientHandler extends SimpleChannelInboundHandler<SmartCarProtocol> {
    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i=0;i<10;i++){
            String messaage = "sent from client";
            int length = messaage.getBytes(Charset.forName("utf-8")).length;
            byte[] content = messaage.getBytes(Charset.forName("utf-8"));
            SmartCarProtocol personProtocal = new SmartCarProtocol(length,content);
            ctx.writeAndFlush(personProtocal);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SmartCarProtocol msg) throws Exception {
        int length = msg.getContentLength();
        int head_data = msg.getHead_data();
        byte[] content = msg.getContent();
        System.out.println("客户端接收到的消息");
        System.out.println("头部:"+head_data);
        System.out.println("长度:"+length);
        System.out.println("消息内容:"+new String(content,Charset.forName("utf-8")));
        System.out.println("客户端接收到的消息数量:"+(++this.count));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
