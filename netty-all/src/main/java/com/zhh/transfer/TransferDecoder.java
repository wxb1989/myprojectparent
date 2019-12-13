package com.zhh.transfer;

import io.netty.buffer.ChannelBuffer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ExceptionEvent;
import io.netty.handler.codec.frame.FrameDecoder;

public class TransferDecoder extends FrameDecoder {

	private int i = 0;
	@Override
	protected Object decode(ChannelHandlerContext cxt, Channel channel,
			ChannelBuffer buffer) throws Exception {
		//没做任何错误处理机制
		System.out.println("第" + i + "次" + "  " + buffer.readableBytes());
		buffer.markReaderIndex();
		i++;
		if(buffer.readableBytes() < 4){
			buffer.resetReaderIndex();
			return null;
		}
		int nameLen = buffer.readInt();
		if(buffer.readableBytes() < nameLen){
			buffer.resetReaderIndex();
			return null;
		}
		System.out.println("文件名长" + nameLen);
		byte[] fileNameBytes = new byte[nameLen];
		
		buffer.readBytes(fileNameBytes);
		String fileName = new String(fileNameBytes);
		int contentLen = buffer.readInt();
		byte[] fileContent = new byte[contentLen];
		if(buffer.readableBytes() < contentLen){
			System.out.println("只读到了" + buffer.readableBytes());
			System.out.println("待下次接收完成再处理");
//			byte[] read = buffer.readBytes(buffer.readableBytes()).array();
//			System.out.println(new String(read));
			buffer.resetReaderIndex();
			return null;
		}
		buffer.readBytes(fileContent);
		System.out.println("处理完毕以后  " + buffer.readableBytes());
		TransferCommand command = new TransferCommand();
		command.setFileContent(fileContent);
		command.setFileName(fileName);
		return command;
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		System.out.println(e.getCause());
		super.exceptionCaught(ctx, e);
	}
	
	

	
}
