package com.zhh.transfer;

import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.ChannelBuffers;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureProgressListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.Channels;
import io.netty.channel.MessageEvent;
import io.netty.channel.SimpleChannelDownstreamHandler;

public class FileRegionTransferEncoder  extends SimpleChannelDownstreamHandler {

	@Override
	public void writeRequested(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		Object o = e.getMessage();
		if(o instanceof FileRegionTransferCommand){
			ChannelBuffer cb = ChannelBuffers.dynamicBuffer();
			ChannelFuture future = e.getFuture();

			final FileRegionTransferCommand command = (FileRegionTransferCommand) o;
	        command.writeHeader(cb);
	        Channels.write(ctx, future, cb);
	        ChannelFuture fileFuture =  Channels.write(ctx.getChannel(), command.getFileRegion());
	       // Channels.write(ctx, future, command.getFileRegion());
	        fileFuture.addListener(new ChannelFutureProgressListener() {
	        	
                public void operationComplete(ChannelFuture future) {
                    command.getFileRegion().releaseExternalResources();
                    System.out.print("上传完成");
                    System.out.println( "  " + System.currentTimeMillis());
                }

                public void operationProgressed(
                        ChannelFuture future, long amount, long current, long total) {
                   //(String.format("%s: %d / %d (+%d)%n", path, current, total, amount));
                }
            });
		}else{
			super.writeRequested(ctx, e);
		}
	}

	
	
}
