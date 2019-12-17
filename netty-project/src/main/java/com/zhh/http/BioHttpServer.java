package com.zhh.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioHttpServer {

	public static final String CR = "\r";
	public static final String LF = "\n";
	public static CountDownLatch latch = new CountDownLatch(1);
	//是否使用线程池
	private static  boolean isDistribute = true;
	public static void main(String[] args){
		
		BioHttpServer.run();

	}
	
	public static class Connector implements Runnable {

		public void run() {
			try {
				latch.await();
				while(true){
					Socket client = new Socket("10.58.99.27", 9090);
					client.setSoTimeout(5000);
					System.out.println(client);
					InputStream ins =client.getInputStream();
					System.out.println(ins.read());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
            
			
			
		}
		
		
	}
	
	public static void run(){
		try{
			//InetSocketAddress address = new InetSocketAddress("10.58.99.27", 9090);
		    //InetAddress address = 	InetAddress.getByName("10.58.99.27");
            ServerSocket serverSocket = new ServerSocket(9090,1);
            ExecutorService threadPool = Executors.newCachedThreadPool();
//            for(int i = 0; i < 1;i++){
//            	new Thread(new BioHttpServer.Connector()).start();
//            }
//            latch.countDown();
            while(true){
                   Socket client = serverSocket.accept();
                   Thread.sleep(800);
                   client.close();
                 //  client.shutdownOutput();
//                   if(isDistribute){
//                	   threadPool.execute(new SocketProcessor(client));
//                   }else{
//                	   new SocketProcessor(client).run();
//                   }
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            
        }
	}
}



class SocketProcessor implements Runnable {
	
	private Socket socket;
	public SocketProcessor(Socket socket){
	    this.socket = socket;	
	}
	public void run() {
		
		InputStream ins;
		PrintWriter pw = null;
		try {
			ins = socket.getInputStream();
			int length = ins.available();
			byte[] request = new byte[length];
			ins.read(request);
			
			pw = new PrintWriter(socket.getOutputStream());
			pw.write("HTTP/1.1 200 OK" + BioHttpServer.CR + BioHttpServer.LF);
			pw.write("Content-Type: text/html; charset=UTF-8" + BioHttpServer.CR + BioHttpServer.LF );
			pw.write("Content-Length: " + "Hello Bio,It wroks".length() + BioHttpServer.CR + BioHttpServer.LF  );
			pw.write(BioHttpServer.CR + BioHttpServer.LF);
			pw.write("Hello Bio,It wroks");
			pw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
//			try {
				//socket.close();
				//pw.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
		
		
	}
	
	
}
