package com.zhh.rpc;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ExceptionEvent;
import io.netty.channel.MessageEvent;
import io.netty.channel.SimpleChannelHandler;

import java.lang.reflect.Method;

public class ServerRpcHandler extends SimpleChannelHandler{

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		Request request = (Request)e.getMessage();
		Response response = new Response();
		try{
			@SuppressWarnings("rawtypes")
			Class cl = Class.forName(request.getClassName());
			Class[] parameterType = new Class[request.getArgs().length];
			for(int i = 0;i < parameterType.length;i++){
				parameterType[i] = request.getArgs()[i].getClass();
			}
			Method m = cl.getMethod(request.getMethodName(), parameterType);
			Object obj = cl.newInstance();
			Object result = m.invoke(obj, request.getArgs());
			response.setStatusCode(200);
			response.setResult(result);
		}catch(Exception ex){
			response.setStatusCode(404);
			response.setResult(ex);
		}
        
		e.getChannel().write(response);
		
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		
		System.out.println(e.getCause());
	}
	
	

	
}
