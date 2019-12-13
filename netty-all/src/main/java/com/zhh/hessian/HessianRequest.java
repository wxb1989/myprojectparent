package com.zhh.hessian;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.zhh.rpc.Response;

public class HessianRequest {

	private String service;
	private String methodName;
	private Object[] args;
	private Response response;
	private int seqNo;

	private transient CountDownLatch latch;
	
	public HessianRequest(){
		
	}

    
	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
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

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public CountDownLatch getLatch() {
		return latch;
	}

	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void await(long timeout) throws InterruptedException{
		latch.await(timeout,TimeUnit.SECONDS);
	}
	
	
}
