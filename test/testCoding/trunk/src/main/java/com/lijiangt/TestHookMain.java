package com.lijiangt;

public class TestHookMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("start main");
		TestHook.print();
		System.out.println("will exit main");
		System.exit(1);
		System.out.println("end main");
	}

}
