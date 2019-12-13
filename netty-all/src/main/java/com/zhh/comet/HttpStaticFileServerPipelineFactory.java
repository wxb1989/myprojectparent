package com.zhh.comet;

import static io.netty.channel.Channels.pipeline;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPipelineFactory;
import io.netty.handler.codec.http.HttpChunkAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpStaticFileServerPipelineFactory implements ChannelPipelineFactory {

	 public ChannelPipeline getPipeline() throws Exception {
	        // Create a default pipeline implementation.
	        ChannelPipeline pipeline = pipeline();

	        // Uncomment the following line if you want HTTPS
	        //SSLEngine engine = SecureChatSslContextFactory.getServerContext().createSSLEngine();
	        //engine.setUseClientMode(false);
	        //pipeline.addLast("ssl", new SslHandler(engine));

	        pipeline.addLast("decoder", new HttpRequestDecoder());
	        pipeline.addLast("aggregator", new HttpChunkAggregator(65536));
	        pipeline.addLast("encoder", new HttpResponseEncoder());
         //   pipeline.addLast("chunkedWriter", new ChunkedWriteHandler());

	        pipeline.addLast("handler", new CometServerHandler());
	        return pipeline;
	    }
}
