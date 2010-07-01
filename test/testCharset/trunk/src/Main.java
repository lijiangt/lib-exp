import java.io.UnsupportedEncodingException;

public class Main {
	private static void printByte(String s, String charset)
			throws UnsupportedEncodingException {
		byte[] by = s.getBytes(charset);//(new String(s.getBytes(), charset)).getBytes(charset);
		System.out.println("" + by.length + " ");
		for (byte b : by) {
			System.out.print(" " + b);
		}
		System.out.println();
	}

	/**
	 * @throws UnsupportedEncodingException
	 * @param args
	 * @throws
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		printByte("a", "UTF-8");
		// 1
		// 97
		//
		printByte("a", "UTF-16");
		// 4
		// -2 -1 0 97
		//
		printByte("a", "GB2312");
		// 1
		// 97
		// 英文字符一个长度
		printByte("a", "GBK");
		// 1
		// 97
		// 英文字符一个长度
		printByte("a", "GB18030");
		// 1
		// 97
		// 英文字符一个长度
		System.out.println();
		System.out.println();
		printByte("中", "UTF-8");
		// 3
		// -28 -72 -83
		printByte("中", "UTF-16");
		// 4
		// -2 -1 78 45
		printByte("中", "GB2312");
		// 2
		// -42 -48
		printByte("中", "GBK");
		// 2
		// -42 -48
		printByte("中", "GB18030");
		// 2
		//  -42 -48
		System.out.println();
		System.out.println();
		printByte("文", "UTF-8");
		// 3
		//  -26 -106 -121
		printByte("文", "UTF-16");
		// 4 
		// -2 -1 101 -121
		printByte("文", "GB2312");
		// 3
		//  -26 -106 -121
		printByte("文", "GBK");
		// 2
		//  -50 -60
		printByte("文", "GB18030");
		// 2
		//  -50 -60
		// String s = "abcd01中文测试";
		// printByte(s,"UTF-8");
		// printByte(s,"UTF-16");
	}
	
	
	public static void main2(String[] args) throws UnsupportedEncodingException {
		byte[] by = "文".getBytes("GBK");
		System.out.println("" + by.length + " ");
		for (byte b : by) {
			System.out.print(" " + b);
		}
		System.out.println();
		System.out.println(new String(by,"GBK"));
//		System.out.println("文".length());
//		System.out.println(new String(new String("文".getBytes("GBK"),"GBK").getBytes("GBK")));
	}
}
