package com.zhh.transfer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelStateEvent;
import io.netty.channel.MessageEvent;
import io.netty.channel.SimpleChannelHandler;

import java.io.File;
import java.io.FileOutputStream;

public class TransferServerHandler extends SimpleChannelHandler {

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
        
//		TransferCommand command = (TransferCommand)e.getMessage();
//		if(command == null)
//			return;
//		File file = new File(command.getFileName());
//		FileOutputStream fos = new FileOutputStream(file);
//		fos.write(command.getFileContent());
//		fos.flush();
//		fos.close();
		
		TransferFile transferFile = (TransferFile)e.getMessage();
		System.out.println(transferFile.getFileName());
		System.out.println(transferFile.isSuccess());
	}

	@Override
	public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		System.out.println("[open]" + e.getChannel());
		super.channelOpen(ctx, e);
	}
	
	

	
}
