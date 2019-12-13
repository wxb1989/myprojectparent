package com.zhh.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestConnector {

	public static void main(String[] args) {
		try {
			Socket client = new Socket("10.58.99.27", 9090);
			// client.setSoTimeout(5000);
			System.out.println(client);
			InputStream ins = client.getInputStream();
			int i = 0;
			// System.out.println(ins.read());
			while (i++ < 1000000) {
				client.getOutputStream().write(64);
			}
			System.out.println(ins.read());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
