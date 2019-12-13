package com.zhh.hessian.server;

import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.ChannelBufferInputStream;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ExceptionEvent;
import io.netty.handler.codec.frame.LengthFieldBasedFrameDecoder;

import java.io.InputStream;

import com.caucho.hessian.io.SerializerFactory;
import com.zhh.hessian.HessianRequest;
import com.zhh.hessian.common.NettyHessianInput;

public class HessianDecoder extends LengthFieldBasedFrameDecoder {

	
	public HessianDecoder(int maxObjectSize) {
		super(maxObjectSize, 0, 4, 0, 4);
	}
	
	public HessianDecoder(){
		this(1048576);
	}

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel,
			ChannelBuffer buffer) throws Exception {
		
		ChannelBuffer frame = (ChannelBuffer) super.decode(ctx, channel, buffer);
        if (frame == null) {
            return null;
        }
        
        InputStream ins = new ChannelBufferInputStream(frame);
        
        return ins;
        
	}

	@Override
	protected ChannelBuffer extractFrame(ChannelBuffer buffer, int index,
			int length) {
		
		return buffer.slice(index, length);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		super.exceptionCaught(ctx, e);
		System.out.println("HessianDecoder" + e.getCause());
	}
	
	

}
