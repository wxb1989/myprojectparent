package com.zhh.transfer;

import io.netty.buffer.ChannelBuffer;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;

import java.io.RandomAccessFile;

public class FileRegionTransferCommand {

	private String distFileName;
	private FileRegion fileRegion;
	
	public FileRegionTransferCommand(String srcFileName,String distFileName) throws Exception{
		
		RandomAccessFile raf = new RandomAccessFile(srcFileName, "r");
		fileRegion = new DefaultFileRegion(raf.getChannel(), 0L, raf.length());
		this.distFileName = distFileName;
	}
	
	public void writeHeader(ChannelBuffer channelBuffer){
		channelBuffer.writeInt(distFileName.length());
		channelBuffer.writeBytes(distFileName.getBytes());
		channelBuffer.writeInt((int)fileRegion.getCount());//TODO
	}

	public FileRegion getFileRegion() {
		return fileRegion;
	}
	
}
