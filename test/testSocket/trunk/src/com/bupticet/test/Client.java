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
import java.net.Socket;

/**
 * @author lijt
 * 
 */
public class Client implements Runnable {
	private final String[] args;
	private int times;

	/**
	 * 
	 */
	public Client(String[] args) {
		this.args = args;
		times = Integer.parseInt(args[3]);
	}

	private void execute() {
		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			socket = new Socket(args[0], Integer.parseInt(args[1]));
			out = new BufferedOutputStream(socket.getOutputStream());
			out.write(args[2].getBytes("UTF-8"));
			out.flush();
			socket.shutdownOutput();
			in = new BufferedInputStream(socket.getInputStream());
			ByteArrayOutputStream response = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length = 0;
			do {
				length = in.read(buffer);
				if (length == -1) {
					break;
				}
				response.write(buffer, 0, length);
			} while (true);

			System.out.println(""+(times+1)+": "+response.toString("UTF-8"));
			
			
//			out = new BufferedOutputStream(socket.getOutputStream());
//			out.write("The end!".getBytes("UTF-8"));
//			out.flush();
//			socket.shutdownOutput();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
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
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public void run() {
//		if (times-- > 0) {
//			execute();
//		}
		while(times-->0){
			execute();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 4) {
			throw new RuntimeException("You must give four arguments!");
		}
		Thread thread = new Thread(new Client(args));
		thread.start();

	}

}
