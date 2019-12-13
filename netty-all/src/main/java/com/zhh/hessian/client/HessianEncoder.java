package com.zhh.hessian.client;

import static io.netty.buffer.ChannelBuffers.dynamicBuffer;

import com.caucho.hessian.io.SerializerFactory;
import com.zhh.hessian.HessianRequest;
import com.zhh.hessian.common.NettyHessianOutput;

import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.ChannelBufferOutputStream;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.oneone.OneToOneEncoder;

public class HessianEncoder extends OneToOneEncoder {

	private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
	private final int estimatedLength;
	private SerializerFactory serializerFactory = new SerializerFactory();
	public HessianEncoder(){
		this(512);
	}
	public HessianEncoder(int estimatedLength){
		 if (estimatedLength < 0) {
	            throw new IllegalArgumentException(
	                    "estimatedLength: " + estimatedLength);
	        }
	        this.estimatedLength = estimatedLength;
	}
	@Override
	protected Object encode(ChannelHandlerContext ctx, Channel channel,
			Object msg) throws Exception {
		
		 ChannelBufferOutputStream bout =
		            new ChannelBufferOutputStream(dynamicBuffer(
		                    estimatedLength, ctx.getChannel().getConfig().getBufferFactory()));
		  bout.write(LENGTH_PLACEHOLDER);
		  NettyHessianOutput output = new NettyHessianOutput(bout);
		  output.setSerializerFactory(serializerFactory);
		  HessianRequest request = (HessianRequest)msg;
		  output.nettyCall(request);
		  output.flush();
		  output.close();
		  
		  ChannelBuffer encoded = bout.buffer();
	      encoded.setInt(0, encoded.writerIndex() - 4);
		  
	      return encoded;
	}
	
	

}
