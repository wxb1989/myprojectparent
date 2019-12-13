package com.zhh.httpclient;

import io.netty.bootstrap.ClientBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioClientSocketChannelFactory;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.util.internal.ConcurrentHashMap;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class NettyHttpClient {
	
	private ClientBootstrap bootstrap;
	private ConcurrentHashMap<String, Channel> connectiones;
	
	public NettyHttpClient(){
		
		connectiones = new ConcurrentHashMap<String, Channel>();
		run();
	}
	
	private void run(){
		 // Configure the client.
       bootstrap = new ClientBootstrap(
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool()));
        bootstrap.setPipelineFactory(new HttpStaticFileServerPipelineFactory());
	}
	
	
	public void openConnection(String host,int port,String uri){
		ChannelFuture  connFuture = bootstrap.connect(new InetSocketAddress(host, port));
		Channel channel = connFuture.awaitUninterruptibly().getChannel();
		
	}
	public HttpResponse get(String host,int port,String uri){
		Channel channel = connectiones.get(host);
		if(channel == null || !channel.isConnected()){
			
			ChannelFuture  connFuture = bootstrap.connect(new InetSocketAddress(host, port));
			channel = connFuture.awaitUninterruptibly().getChannel();
		}
		HttpClientRequest request  = new HttpClientRequest(host,uri, HttpMethod.GET);
		ChannelFuture writeFuture = channel.write(request);
		try{
			request.await(10);
		}catch(Exception e){
              return null;			
 		}
		
		HttpResponse response = request.getResponse();
		if(response == null)
			return null;
		String connKeepAlive = response.getHeader("Connection");
		if(connKeepAlive == null || "close".equals(connKeepAlive)){
			writeFuture.addListener(ChannelFutureListener.CLOSE);
		}else{
			connectiones.put(host, channel);
		}
		return request.getResponse();
	}
	
	public int getConnectionSize(){
		
		return connectiones.size();
	}
	
	public void shutdown(){
		
		bootstrap.releaseExternalResources();
	}
	
	public  static void  main(String[] args){
		
		NettyHttpClient client = new NettyHttpClient();
		for(int i = 0;i < 20;i++){
			String stock = "/list=sh601006";
			if(i % 2 == 1)
				stock = "/list=sh600166";
			HttpResponse response = client.get("hq.sinajs.cn",80,stock);
			System.out.println(new String(response.getContent().array()));
			//client.openConnection("hq.sinajs.cn",80,"/list=sh601006");
		}
//		response = client.get("hq.sinajs.cn",80,"/list=sh601006");
//		System.out.println(new String(response.getContent().array()));
		System.out.println(client.getConnectionSize());
		client.shutdown();
	}

}
