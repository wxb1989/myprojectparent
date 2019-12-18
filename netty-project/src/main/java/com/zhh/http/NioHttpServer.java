package com.zhh.http;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class NioHttpServer {


	public static final String CR = "\r";
	public static final String LF = "\n";
	private ByteBuffer  readBuffer  = ByteBuffer.allocate(1024);
	private Selector selector;

	private ConcurrentHashMap<SocketChannel, BlockingQueue<String>> writeContext;

	public static void main(String[] args){

		NioHttpServer server = new NioHttpServer();
		server.run();
	}
	public  void run(){

		try {
			selector = Selector.open();
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			InetSocketAddress isa = new InetSocketAddress(7070);
			serverChannel.socket().bind(isa);
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			writeContext = new ConcurrentHashMap<SocketChannel, BlockingQueue<String>>();
			while(true){

				int count = selector.select(1000);
				if(count > 0){
					Iterator<SelectionKey>keys = selector.selectedKeys().iterator();
					while(keys.hasNext()){
						SelectionKey currentKey = keys.next();
						if(currentKey.isAcceptable()){
							SocketChannel client = serverChannel.accept();
							client.configureBlocking(false);
							client.register(selector,SelectionKey.OP_READ);
							System.out.println("Accept Time" + System.currentTimeMillis());
						}else if(currentKey.isReadable()){
							handleRead(currentKey);
						}else if(currentKey.isWritable()){
							handleWrite(currentKey);
						}
						keys.remove();
					}

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void  handleWrite(SelectionKey key){
		SocketChannel channel = (SocketChannel)key.channel();
		BlockingQueue<String> queue = writeContext.get(channel);
		if(queue == null)
			return;
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(queue.size() > 0){
			String response =  queue.poll();
			buffer.put(("HTTP/1.0 200 OK" + BioHttpServer.CR + BioHttpServer.LF).getBytes());
			buffer.put(("Content-Type: text/html; charset=UTF-8" + BioHttpServer.CR + BioHttpServer.LF ).getBytes());
			buffer.put(("Content-Length: " + response.length() + BioHttpServer.CR + BioHttpServer.LF  ).getBytes());
//			buffer.putChar('\r');
//			buffer.putChar('\n');
			buffer.put((BioHttpServer.CR + BioHttpServer.LF).getBytes());
			buffer.put(response.getBytes());
			buffer.flip();
			try {
				int writeNum =channel.write(buffer);
				System.out.println("Written Number:"  + writeNum);
				System.out.println("Write:" + System.currentTimeMillis());
			} catch (IOException e) {
				e.printStackTrace();
			}
			buffer.clear();
		}
	}
	private void handleRead(SelectionKey key){

		SocketChannel channel = (SocketChannel)key.channel();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		readBuffer.clear();
		try {
			while((channel.read(readBuffer)) > 0){
				//这里本应该是解析request
				if(!readBuffer.hasRemaining()) {
					break;
				}
			}
			BlockingQueue<String> queue = writeContext.get(channel);
			if(queue == null){
				queue = new ArrayBlockingQueue<String>(1000);
			}
			queue.offer("Hello Nio. It works!" + System.currentTimeMillis());
			writeContext.put(channel, queue);
			key.interestOps(SelectionKey.OP_WRITE);
			selector.wakeup();
			System.out.println("Read:" + System.currentTimeMillis());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
