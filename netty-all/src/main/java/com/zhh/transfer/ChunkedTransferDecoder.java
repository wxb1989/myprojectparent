package com.zhh.transfer;

import io.netty.buffer.ChannelBuffer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.replay.ReplayingDecoder;

import java.io.FileOutputStream;

public class ChunkedTransferDecoder extends
		ReplayingDecoder<ChunkedTransferDecoder.State> {

	private int chunkSize = 1024;
	private TransferFile currentTransfer;
	private int writeLoop = 0;

	protected enum State {
		READ_FILENAME_LENGTH, READ_FILENAME, READ_FILECONTENT_LENGTH, READ_FILECONTENT
	}

	public ChunkedTransferDecoder(int chunkSize) {
		super(State.READ_FILENAME_LENGTH, true);
		this.chunkSize = chunkSize;
	}
	
	private Object reset(){
		
		currentTransfer.closeFos();
		TransferFile result = this.currentTransfer;
		this.currentTransfer = null;
		checkpoint(State.READ_FILENAME_LENGTH);
		writeLoop = 0;
		return result;
	}

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel,
			ChannelBuffer buffer, State state) throws Exception {

		switch (state) {
		case READ_FILENAME_LENGTH: {
			int fileNameLength = buffer.readInt();
			currentTransfer = new TransferFile();
			currentTransfer.setFileNameLength(fileNameLength);
			checkpoint(State.READ_FILENAME);
		}
		case READ_FILENAME:{
			byte[] fileNameBytes = new byte[currentTransfer.getFileNameLength()];
			buffer.readBytes(fileNameBytes);
			String fileName = new String(fileNameBytes);
			try{
				currentTransfer.setFileName(fileName);
				FileOutputStream fos = new FileOutputStream(fileName);
				currentTransfer.setFos(fos);
			}catch(Exception e){
				currentTransfer.setSuccess(false);
				return reset();
			}
			
		}
		case READ_FILECONTENT_LENGTH:{
			currentTransfer.setFileContentLength(buffer.readInt());
			checkpoint(State.READ_FILECONTENT);
		}
		case READ_FILECONTENT:{
			writeLoop++;
			int currentChunkSize = Math.min(currentTransfer.getFileContentLength(), chunkSize);
			int maxCanRead = buffer.readableBytes();
			
//			if(maxCanRead < currentTransfer.getFileContentLength()){
//				currentChunkSize = Math.min(maxCanRead, chunkSize);
//			}else{
//				currentChunkSize = currentTransfer.getFileContentLength();
//			}
			try{
				
				currentTransfer.getFos().write(buffer.readBytes(currentChunkSize).array());
				currentTransfer.decrement(currentChunkSize);
			}catch(Exception e){
				currentTransfer.setSuccess(false);
				return reset();
			}
			
			if(currentTransfer.isLast()){
				currentTransfer.setSuccess(true);
				System.out.println("Write Loop" + writeLoop);
				return reset();
			}
				
		}

		}
		
		return null;
	}

}
