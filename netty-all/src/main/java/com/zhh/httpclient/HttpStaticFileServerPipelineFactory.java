package com.zhh.httpclient;

import static io.netty.channel.Channels.pipeline;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPipelineFactory;
import io.netty.handler.codec.http.HttpChunkAggregator;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpStaticFileServerPipelineFactory implements ChannelPipelineFactory {

	 public ChannelPipeline getPipeline() throws Exception {
	        ChannelPipeline pipeline = pipeline();

	        pipeline.addLast("decoder", new HttpResponseDecoder());
	        pipeline.addLast("aggregator", new HttpChunkAggregator(65536));
	        pipeline.addLast("encoder", new HttpRequestEncoder());
            pipeline.addLast("chunkedWriter", new ChunkedWriteHandler());
            pipeline.addLast("client", new HttpClientHandler());
	        return pipeline;
	    }
}
