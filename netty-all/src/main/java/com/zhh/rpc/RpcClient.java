package com.zhh.rpc;

import io.netty.bootstrap.ClientBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPipelineFactory;
import io.netty.channel.Channels;
import io.netty.channel.socket.nio.NioClientSocketChannelFactory;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class RpcClient {

	private final String host;
    private final int port;
    private Channel channel;
    
    public RpcClient(String host,int port){
    	
    	this.host = host;
    	this.port = port;
    	run();
    }
    
    private void run(){
    	 // Configure the client.
        ClientBootstrap bootstrap = new ClientBootstrap(
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool()));

        // Set up the pipeline factory.
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(
                        new ObjectEncoder(),
                        new ObjectDecoder(
                                ClassResolvers.cacheDisabled(getClass().getClassLoader())),
                        new ClientRpcHandler());
            }
        });

        // Start the connection attempt.
        ChannelFuture  future = bootstrap.connect(new InetSocketAddress(host, port));
        channel = future.awaitUninterruptibly().getChannel();
        
    }
    
    
    public void request(Request r){
    	channel.write(r);
    }
    
    
    public static void main(String[] args){
    	
    	RpcClient client = new RpcClient("localhost",8080);
    	Request request = new Request();
    	request.setClassName("com.zhh.rpc.Test");
    	request.setArgs(new Integer[]{1,2});
    	request.setMethodName("add");
    	client.request(request);
    	try {
			request.await(1);
			System.out.println((Integer)(request.getResponse().getResult()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
}
