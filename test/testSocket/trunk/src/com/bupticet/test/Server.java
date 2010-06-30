/**
 * 
 */
package com.bupticet.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lijt
 * 
 */
public class Server implements Runnable {

	private final ServerSocket serverSocket;

	/**
	 * 
	 */
	public Server(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		while (true) {
			try {
				socket = serverSocket.accept();
				out = new BufferedOutputStream(socket.getOutputStream());
				in = new BufferedInputStream(socket.getInputStream());
				ByteArrayOutputStream request = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int length = 0;
				do {
					length = in.read(buffer);
					if (length == -1 ) {
						break;
					}
					request.write(buffer, 0, length);
				} while (true);

				String req = request.toString("UTF-8");
				System.out.println("Accept: " + req);
				out.write(("Server reply: " + req).getBytes("UTF-8"));
				out.flush();
				socket.shutdownOutput();

				
//				in = new BufferedInputStream(socket.getInputStream());
//				request = new ByteArrayOutputStream();
//				 buffer = new byte[1024];
//				length = 0;
//				do {
//					length = in.read(buffer);
//					if (length == -1 ) {
//						break;
//					}
//					request.write(buffer, 0, length);
//				} while (true);
//
//				req = request.toString("UTF-8");
//				System.out.println("Accept: " + req);
				
			} catch (IOException e) {
				e.printStackTrace();
				return;
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t = new Thread(new Server(12345));
		t.start();
	}
}
