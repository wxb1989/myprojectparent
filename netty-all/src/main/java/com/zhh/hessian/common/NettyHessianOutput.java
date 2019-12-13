package com.zhh.hessian.common;

import java.io.IOException;
import java.io.OutputStream;

import com.caucho.hessian.io.HessianOutput;
import com.zhh.hessian.HessianRequest;

public class NettyHessianOutput extends  HessianOutput {

	private int _version = 1;
	public NettyHessianOutput(OutputStream os){
		super(os);
	}
	
	public void nettyCall(HessianRequest request) throws IOException {
		Object[] args = request.getArgs();
		int length = args != null ? args.length : 0;
		startCall(request.getService(),request.getMethodName(),length);
		 for (int i = 0; i < length; i++)
		      writeObject(args[i]);
		completeCall();
	}
	
	public void startCall(String service,String method, int length) throws IOException {
		
		    os.write('c');
		    os.write(_version);
		    os.write(0);
            os.write('s');
            this.writeInt(SequeueUtil.sequeue());//32bit
            os.write('r');
            int len = service.length();
            os.write(len >> 8);//16bit 足够容纳service名 和method名
		    os.write(len);
		    printString(service,0,len);//用utf编码 相当于string.getBytes()
		    os.write('m');
		    len = method.length();//16bit
		    os.write(len >> 8);
		    os.write(len);
		    printString(method, 0, len);
		    os.write(length);//8bit 足够容纳参数列表的长度
		
	}

	
	
}
