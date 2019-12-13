package com.zhh.comet;

public class Message {

	private String type;
	private String body;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return body + "<br/>" ;
	}
	
	
	
}
