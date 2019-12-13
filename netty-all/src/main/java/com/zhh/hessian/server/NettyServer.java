package com.zhh.hessian.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPipelineFactory;
import io.netty.channel.Channels;
import io.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import com.zhh.rpc.RpcServer;

public class NettyServer {

	  private final int port;

	    public NettyServer(int port) {
	        this.port = port;
	    }

	    public void run() {
	        // Configure the server.
	        ServerBootstrap bootstrap = new ServerBootstrap(
	                new NioServerSocketChannelFactory(
	                        Executors.newCachedThreadPool()));

	        // Set up the pipeline factory.
	        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
	        	
	            public ChannelPipeline getPipeline() throws Exception {
	                return Channels.pipeline(
	                        new HessianDecoder(),
	                        new HessianRequestHandler());
	            }
	        });

	        // Bind and start to accept incoming connections.
	        bootstrap.bind(new InetSocketAddress(port));
	    }

	    public static void main(String[] args) throws Exception {
	        int port;
	        if (args.length > 0) {
	            port = Integer.parseInt(args[0]);
	        } else {
	            port = 8080;
	        }
	        new NettyServer(port).run();
	    }
}
