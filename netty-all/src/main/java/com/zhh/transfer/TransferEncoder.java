package com.zhh.transfer;

import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.ChannelBuffers;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.Channels;
import io.netty.channel.MessageEvent;
import io.netty.channel.SimpleChannelDownstreamHandler;


public class TransferEncoder extends SimpleChannelDownstreamHandler  {

	@Override
	public void writeRequested(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		
		Object o = e.getMessage();
		if(o instanceof TransferCommand){
			ChannelBuffer cb = ChannelBuffers.dynamicBuffer();
			ChannelFuture future = e.getFuture();

			TransferCommand command = (TransferCommand) o;
	        command.write(cb);
	        Channels.write(ctx, future, cb);
		}else{
			super.writeRequested(ctx, e);
		}
	}

	
}
