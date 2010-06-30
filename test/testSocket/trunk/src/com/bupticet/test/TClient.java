package com.bupticet.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class TClient implements Runnable{
	private final String[] args;

	public TClient(String[] args) {
		this.args = args;
	}
	
	private void execute() {
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		String msg = "";
		
		try {
			socket = new Socket(args[0], Integer.parseInt(args[1]));
		
			pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println("test");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while ((msg = br.readLine()) != null) { // 接收和发送数据,直到通信结束
				System.out.println(msg);
				pw.println("bye");
			}
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
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (pw != null) {
					pw.close();
				}
			}
		}
	
	public void run() {
			execute();
	}
	
	
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			int times;
			if (args.length != 4) {
				throw new RuntimeException("You must give four arguments!");
			}
			times = Integer.parseInt(args[3]);
			for(int i = times; i>0;i--){
				Thread thread = new Thread(new TClient(args));
				thread.start();
			}
		}
		
}
