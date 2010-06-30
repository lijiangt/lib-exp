package com.bupticet.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TServer {
	private ServerSocket serverSocket;


	public TServer(int port) throws IOException {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Buffersize:"+serverSocket.getReceiveBufferSize());
			System.out.println("port:"+serverSocket.getLocalPort());
			System.out.println("服务器启动");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void service() {
		while (true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				Thread workThread=new Thread(new THandler(socket));
				workThread.start();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}

	public static void main(String args[]) throws Exception {
		System.out.print(args.length);
		if (args.length < 1) {
			throw new RuntimeException("You must give port arguments:cmd port");
		}
		TServer server = new TServer(Integer.parseInt(args[0]));
		server.service();
	}
}
