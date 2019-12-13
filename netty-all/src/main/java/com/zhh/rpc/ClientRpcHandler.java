package com.zhh.rpc;

import io.netty.channel.ChannelEvent;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelState;
import io.netty.channel.ChannelStateEvent;
import io.netty.channel.MessageEvent;
import io.netty.channel.SimpleChannelHandler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ClientRpcHandler extends SimpleChannelHandler {

	private BlockingQueue<Request> requestQueue = new LinkedBlockingDeque<Request>();
	@Override
	public void handleUpstream(ChannelHandlerContext context, ChannelEvent e)
			throws Exception {
		if (e instanceof ChannelStateEvent &&
	            ((ChannelStateEvent) e).getState() != ChannelState.INTEREST_OPS) {
	           System.out.println(e.toString());
	        }
		super.handleUpstream(context, e);
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		
		Response response = (Response)e.getMessage();
		Request request = requestQueue.take();
		request.setResponse(response);
		request.done();
	}

	@Override
	public void writeRequested(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		requestQueue.put((Request)e.getMessage());
		super.writeRequested(ctx, e);
	}
	
	

}
