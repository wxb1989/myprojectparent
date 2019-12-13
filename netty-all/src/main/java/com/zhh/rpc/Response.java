package com.zhh.rpc;

import java.io.Serializable;

public class Response implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int statusCode;
	private Object result;
	
	public Response(){
		
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	

}
