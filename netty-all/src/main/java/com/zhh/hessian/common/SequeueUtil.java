package com.zhh.hessian.common;

import java.util.concurrent.atomic.AtomicInteger;

public class SequeueUtil {

	
	private static final AtomicInteger sequeue = new AtomicInteger(0);
	
	private SequeueUtil(){
		
	}
	
	public static int sequeue(){
		
		return sequeue.getAndIncrement();
	}
}
