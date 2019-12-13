package com.zhh.hessian.common;

import java.io.IOException;
import java.io.InputStream;

import com.caucho.hessian.io.HessianInput;

public class NettyHessianInput extends HessianInput {


	private InputStream ins;
	public NettyHessianInput(InputStream ins){
		
		super(ins);
		this.ins = ins;
	}
	
	public Object[] readArgs() throws IOException{
		
		int length = ins.read();
		Object[] args = new Object[length];
		return args;
	}
	
	public String readService() throws IOException{
		
		
		 int tag = ins.read();
		    
		    if (tag != 'r')
		      throw error("expected hessian service ('r') at " + codeName(tag));
		    int d1 = ins.read();
		    int d2 = ins.read();

		    int _chunkLength = d1 * 256 + d2;
		    StringBuilder _sbuf = new StringBuilder(_chunkLength);
		    while(_chunkLength-- >  0){
		    	_sbuf.append((char)parseUTF8Char() );
		    }
		    return _sbuf.toString();
	}
	
	public int readSequence() throws IOException {
		
		int tag = ins.read();
		if(tag != 's')
			throw error("expected hessian sequence ('s') at " + codeName(tag));
		return this.readInt();
	}
	
	 private int parseUTF8Char()
			    throws IOException
			  {
			    int ch = ins.read();

			    if (ch < 0x80)
			      return ch;
			    else if ((ch & 0xe0) == 0xc0) {
			      int ch1 = ins.read();
			      int v = ((ch & 0x1f) << 6) + (ch1 & 0x3f);

			      return v;
			    }
			    else if ((ch & 0xf0) == 0xe0) {
			      int ch1 = ins.read();
			      int ch2 = ins.read();
			      int v = ((ch & 0x0f) << 12) + ((ch1 & 0x3f) << 6) + (ch2 & 0x3f);

			      return v;
			    }
			    else
			      throw error("bad utf-8 encoding at " + codeName(ch));
			  }
}
