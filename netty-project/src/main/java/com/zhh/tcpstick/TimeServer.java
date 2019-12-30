package com.zhh.tcpstick;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 利用LineBasedFrameDecoder解决TCP粘包问题
 */
public class TimeServer {

    public static void main(String[] args) throws Exception {
        int port=9090;
        if(args!=null&&args.length>0){
            try {
                port=Integer.valueOf(args[0]);
            } catch (Exception e) {
                // 采用默认值
            }
        }

        new TimeServer().bind(port);
    }

    public void bind(int port) throws Exception{
        /*
         * 配置服务端的NIO线程组，它包含了一组NIO线程，专门用于网络事件的处理，实际上它们就是Reactor线程组。
         * 这里创建两个的原因：一个用于服务端接受客户端的连接，
         * 另一个用于进行SocketChannel的网络读写。
         */
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        try {
            //ServerBootstrap对象，Netty用于启动NIO服务端的辅助启动类，目的是降低服务端的开发复杂度。
            ServerBootstrap b=new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
             /*
              * 绑定I/O事件的处理类ChildChannelHandler，它的作用类似于Reactor模式中的handler类，
              * 主要用于处理网络I/O事件，例如：记录日志、对消息进行编解码等。
              */
                    .childHandler(new ChildChannelHandler());
            /*
             * 绑定端口，同步等待成功（调用它的bind方法绑定监听端口，随后，调用它的同步阻塞方法sync等待绑定操作完成。
             * 完成之后Netty会返回一个ChannelFuture,它的功能类似于JDK的java.util.concurrent.Future，
             * 主要用于异步操作的通知回调。）
             */
            ChannelFuture f=b.bind(port).sync();

            //等待服务端监听端口关闭（使用f.channel().closeFuture().sync()方法进行阻塞，等待服务端链路关闭之后main函数才退出。）
            f.channel().closeFuture().sync();
        }finally{
            //优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel arg0) throws Exception {
            arg0.pipeline().addLast(new LineBasedFrameDecoder(1024));
            arg0.pipeline().addLast(new StringDecoder());
            arg0.pipeline().addLast(new TimeServerHandler());
        }
    }
}
