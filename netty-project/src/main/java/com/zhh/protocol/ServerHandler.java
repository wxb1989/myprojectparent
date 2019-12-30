package com.zhh.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * 服务端接收的消息
 */
public class ServerHandler extends SimpleChannelInboundHandler<SmartCarProtocol> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SmartCarProtocol msg) throws Exception {
        System.out.println("服务端接受到的数据：");
        System.out.println("数据长度:"+msg.getContentLength());
        System.out.println("数据内容："+ new String(msg.getContent(), Charset.forName("utf-8")) );
        System.out.println("服务端接收到的消息数量:"+(++count));

        String responseMessage = UUID.randomUUID().toString();
        int responseLength = responseMessage.getBytes(Charset.forName("utf-8")).length;
        byte[] responseContent = responseMessage.getBytes(Charset.forName("utf-8"));
        SmartCarProtocol personProtocal = new SmartCarProtocol();
        personProtocal.setContentLength(responseLength);
        personProtocal.setContent(responseContent);
        ctx.writeAndFlush(personProtocal);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
