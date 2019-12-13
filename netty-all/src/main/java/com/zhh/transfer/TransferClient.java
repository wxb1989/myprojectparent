package com.zhh.transfer;

import io.netty.bootstrap.ClientBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPipelineFactory;
import io.netty.channel.Channels;
import io.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TransferClient {

	private final String host;
	private final int port;
	private Channel channel;

	public TransferClient(String host, int port) {

		this.host = host;
		this.port = port;
		run();
	}

	private void run() {
		// Configure the client.
		ClientBootstrap bootstrap = new ClientBootstrap(
				new NioClientSocketChannelFactory(
						Executors.newCachedThreadPool()));

		// Set up the pipeline factory.
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			public ChannelPipeline getPipeline() throws Exception {
				ChannelPipeline pipeline = Channels.pipeline();
				pipeline.addLast("encoder", new FileRegionTransferEncoder());
				pipeline.addLast("decoder", new TransferDecoder());
				return pipeline;
			}
		});
		
		//bootstrap.setOptions(options)

		// Start the connection attempt.
		ChannelFuture future = bootstrap.connect(new InetSocketAddress(host,
				port));
		channel = future.awaitUninterruptibly().getChannel();

	}

	public synchronized void request(FileRegionTransferCommand command) {
		channel.write(command);
	}

	private static class TransferThread implements Runnable {

		private AtomicInteger count;
        private TransferClient client;
        private CountDownLatch latch;
		
		public TransferThread(AtomicInteger count,TransferClient client,CountDownLatch latch) {
			this.count = count;
			this.client = client;
			this.latch = latch;
		}

		public void run() {

			try {
				for (int i = 0; i < 1; i++) {

//					FileRegionTransferCommand command = new FileRegionTransferCommand(
//							"c:/7-12xinzheng.rar", "d:/gc/test_l" + count.getAndIncrement() + ".rar");
					

					FileRegionTransferCommand command = new FileRegionTransferCommand(
							"/home/justin/Desktop/anjuke_daily.jar", "/tmp/transfer/anjuke_l" + count.getAndIncrement() + ".jar");
					client.request(command);
					latch.countDown();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {

		TransferClient client = new TransferClient("10.58.99.74", 29998);
		System.out.println("Transfer Client started¡­¡­");
		// File file = new File("c:/gc.log");
		// FileInputStream fis = new FileInputStream(file);
		// byte[] fileContent = new byte[fis.available()];
		// fis.read(fileContent);
		// fis.close();
		// TransferCommand command = new TransferCommand();
		// command.setFileContent(fileContent);
		// // command.setFileName("d:/gc/test.rar");
		// // client.request(command);
		// // client.request(command);
		// for(int i = 0; i < 1;i++){
		// command.setFileName("d:/gc/" + i + ".log");
		// client.request(command);
		// }

//		try {
//			for (int i = 0; i < 1000; i++) {
//
//				FileRegionTransferCommand command = new FileRegionTransferCommand(
//						"c:/7-12xinzheng.rar", "d:/gc/test_l" + i + ".rar");
//				client.request(command);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		AtomicInteger count = new AtomicInteger(0);
		System.out.println("Start Time " + System.currentTimeMillis());
		CountDownLatch latch = new CountDownLatch(60);
		for(int i = 0; i <1; i++ ){
			
			new Thread(new TransferThread(count, client,latch)).start();
			
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
