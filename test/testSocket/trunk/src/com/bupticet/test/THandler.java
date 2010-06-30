package com.bupticet.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class THandler implements Runnable {
	private Socket socket;

	public THandler(Socket socket) {
		this.socket = socket;
	}

	private PrintWriter getWriter(Socket socket) throws IOException {
		return  new PrintWriter(
                socket.getOutputStream(), true);
	}

	private BufferedReader getReader(Socket socket) throws IOException {
		return new BufferedReader(new InputStreamReader(
				socket.getInputStream()));	
	}

	public String echo(String msg) {
		return "Reply:"+msg;
	}

	public void run() {
		try {
			System.out.println("New connection accepted "
					+ socket.getInetAddress() + ":" + socket.getPort());
			BufferedReader br = getReader(socket);
			PrintWriter pw = getWriter(socket);
			String msg = null;
			while ((msg = br.readLine()) != null) { // 接收和发送数据,直到通信结束
				System.out.println(msg);
				pw.println(echo(msg));
				if (msg.equals("bye")) {
					System.out.println("exit signal");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close(); // 断开连接
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
