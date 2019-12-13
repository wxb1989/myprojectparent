package com.zhh.transfer;

import io.netty.buffer.ChannelBuffer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.frame.FrameDecoder;

public class OTransferDecoder extends FrameDecoder {

	private int i = 0;
	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel,
			ChannelBuffer buffer) throws Exception {
		i++;
	    int length = buffer.readableBytes();
	    byte[] fileNameBytes = new byte[length];
	    buffer.readBytes(fileNameBytes);
	    String content = new String(fileNameBytes);
	    System.out.println(length + "    i:"  + i);
		return null;
	}

}
