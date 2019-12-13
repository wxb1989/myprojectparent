package com.zhh.httpclient;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.MessageEvent;
import io.netty.channel.SimpleChannelHandler;
import io.netty.handler.codec.http.HttpResponse;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class HttpClientHandler extends SimpleChannelHandler  {

	//private BlockingQueue<HttpClientRequest> requestQueue = new LinkedBlockingDeque<HttpClientRequest>();

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		HttpResponse response = (HttpResponse)e.getMessage();
		Channel ch = ctx.getChannel();
		BlockingQueue<HttpClientRequest> sendedQueue = (BlockingQueue<HttpClientRequest>)ch.getAttachment();
		HttpClientRequest request = sendedQueue.poll();
		request.setResponse(response);
		request.done();
	}
	

	@Override
	public void writeRequested(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		Object p = e.getMessage();
		if(p instanceof HttpClientRequest){
			HttpClientRequest request = (HttpClientRequest)e.getMessage();
			Channel ch = ctx.getChannel();
			BlockingQueue<HttpClientRequest> sendedQueue = (BlockingQueue<HttpClientRequest>)ch.getAttachment();
			if(sendedQueue == null){
				sendedQueue = new LinkedBlockingDeque<HttpClientRequest>();
				ch.setAttachment(sendedQueue);
			}
			sendedQueue.put(request);
			ctx.getChannel().write(request.getRequest());
		}else{
			
			super.writeRequested(ctx, e);
		}
	}
	
	
}
