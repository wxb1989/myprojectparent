package com.zhh.transfer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPipelineFactory;
import io.netty.channel.Channels;
import io.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class TransferServer {
	
	private  final int port;
	
	public TransferServer(int port){
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
            	
            	ChannelPipeline pipeline = Channels.pipeline();
            	pipeline.addLast("encoder", new TransferEncoder());
            	pipeline.addLast("decoder", new ChunkedTransferDecoder(4096 * 32));
            	pipeline.addLast("handler", new TransferServerHandler());
                return pipeline;
            }
        });
        
        bootstrap.setOption("child.receiveBufferSize", "1048576");

        // Bind and start to accept incoming connections.
        bootstrap.bind(new InetSocketAddress(port));
    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 29998;
        }
        System.out.println("Transfer Server started¡­¡­");
        new TransferServer(port).run();
    }

}
