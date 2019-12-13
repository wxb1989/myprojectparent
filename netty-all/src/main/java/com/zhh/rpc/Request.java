package com.zhh.rpc;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String className;
	private String methodName;
	private Object[] args;
	private Response response;

	private transient CountDownLatch latch;
	
	public Request(){
		
		latch = new CountDownLatch(1);
	}

	public String getClassName() {
		return className;
	}
	
	public void await(long timeout) throws InterruptedException{
		latch.await(timeout,TimeUnit.SECONDS);
	}
	
	public void done(){
		latch.countDown();
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
	
	
}
