package com.zhh.comet;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class CometServer {

	 private final int port;

	    public CometServer(int port) {
	        this.port = port;
	    }

	    public void run() {
	        // Configure the server.
	        ServerBootstrap bootstrap = new ServerBootstrap(
	                new NioServerSocketChannelFactory(
	                        Executors.newCachedThreadPool()));

	        // Set up the event pipeline factory.
	        bootstrap.setPipelineFactory(new HttpStaticFileServerPipelineFactory());

	        // Bind and start to accept incoming connections.
	        bootstrap.bind(new InetSocketAddress(port));
	    }

	    public static void main(String[] args) {
	        int port;
	        System.setProperty("udir", "d:\\comet");
	        //System.setProperty("user.dir", "/home/hailei/comet/");
	        if (args.length > 0) {
	            port = Integer.parseInt(args[0]);
	        } else {
	            port = 8080;
	        }
	        new CometServer(port).run();
	    }
}
