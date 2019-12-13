package com.zhh.hessian.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ExceptionEvent;
import io.netty.channel.MessageEvent;
import io.netty.channel.SimpleChannelHandler;

import java.io.InputStream;

import com.caucho.hessian.io.SerializerFactory;
import com.zhh.hessian.HessianRequest;
import com.zhh.hessian.common.NettyHessianInput;

public class HessianRequestHandler extends SimpleChannelHandler {

	private SerializerFactory serializerFactory = new SerializerFactory();

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		InputStream ins = (InputStream) e.getMessage();
		NettyHessianInput nhi = new NettyHessianInput(ins);
		nhi.setSerializerFactory(serializerFactory);
		nhi.readCall();
		HessianRequest request = new HessianRequest();
		request.setSeqNo(nhi.readSequence());
		request.setService(nhi.readService());
		
		System.out.println(request);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		super.exceptionCaught(ctx, e);
		System.out.println("RequestHandler" + e.getCause());
	}
	
	
	
	

}
