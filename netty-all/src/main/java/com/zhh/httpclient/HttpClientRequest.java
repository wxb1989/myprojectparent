package com.zhh.httpclient;

import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpVersion;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HttpClientRequest {

	
	private HttpRequest request;
	private HttpResponse response;
	
	private transient CountDownLatch latch;
	
	public HttpClientRequest(String host,String uri,HttpMethod method){
		
		this.request  = new DefaultHttpRequest(HttpVersion.HTTP_1_1, method, uri);
		request.addHeader("host", host);
		request.addHeader("Connection", "keep-alive");
		this.latch = new CountDownLatch(1);
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public HttpResponse getResponse() {
		return response;
	}

	public void setResponse(HttpResponse response) {
		this.response = response;
	}
	
	public void await(long timeout) throws InterruptedException{
		latch.await(timeout,TimeUnit.SECONDS);
	}
	
	public void done(){
		latch.countDown();
	}
}
