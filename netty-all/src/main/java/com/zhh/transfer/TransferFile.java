package com.zhh.transfer;

import java.io.FileOutputStream;

public class TransferFile {

	private int fileNameLength;
	private String fileName;
	private int fileContentLength;
	private FileOutputStream fos;
	private boolean isSuccess;
	
	public TransferFile(){
		
	}

	public int getFileNameLength() {
		return fileNameLength;
	}

	public void setFileNameLength(int fileNameLength) {
		this.fileNameLength = fileNameLength;
	}

	public int getFileContentLength() {
		return fileContentLength;
	}

	public void setFileContentLength(int fileContentLength) {
		this.fileContentLength = fileContentLength;
	}

	public FileOutputStream getFos() {
		return fos;
	}

	public void setFos(FileOutputStream fos) {
		this.fos = fos;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public int decrement(int chunkSize){
		this.fileContentLength -= chunkSize;
		return this.fileContentLength;
	}
	
	public int rollback(int chunkSize){
		this.fileContentLength += chunkSize;
		return this.fileContentLength;
	}
	
	public boolean isLast(){
		
		return this.fileContentLength == 0;
	}
	
	public void closeFos(){
		
		try{
			if(fos != null)
			 fos.close();
		}catch(Exception e){
			
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
