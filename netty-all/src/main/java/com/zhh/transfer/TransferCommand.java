package com.zhh.transfer;

import io.netty.buffer.ChannelBuffer;

public class TransferCommand {
	
	private String fileName;
	private byte[] fileContent;
	
	public TransferCommand(){
		
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	
	public void write(ChannelBuffer channelBuffer){
		
		channelBuffer.writeInt(fileName.length());
		channelBuffer.writeBytes(fileName.getBytes());
		channelBuffer.writeInt(fileContent.length);
		channelBuffer.writeBytes(fileContent);
	}

}
