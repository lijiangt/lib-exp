package com.lijiangt;

public class TestHook {

	/**
	 * @param args
	 */
	public static void print() {
		System.out.println("start print");
		Runtime.getRuntime().addShutdownHook(new Thread() {

			public void run() {
				System.out.println("start run");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end run");
//				System.exit(0);
			}
		});
		System.out.println("end print");
	}

}
