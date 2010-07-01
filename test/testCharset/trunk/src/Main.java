import java.io.UnsupportedEncodingException;

public class Main {
	private static void printByte(String s, String charset)
			throws UnsupportedEncodingException {
		byte[] by = new String(s.getBytes(), charset).getBytes(charset);
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
		// -2 -1 -1 -3
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
		// 6
		// -2 -1 -28 -72 -1 -3
		printByte("中", "GB2312");
		// 3
		// -28 -72 63
		printByte("中", "GBK");
		// 3
		// -28 -72 63
		printByte("中", "GB18030");
		// 6
		// -28 -72 -124 49 -92 55
		System.out.println();
		System.out.println();
		printByte("文", "UTF-8");
		printByte("文", "GB2312");
		// 2
		// 63 63
		printByte("文", "GBK");
		// 3
		// -26 -106 63
		printByte("文", "GB18030");
		// 6
		// -26 -106 -124 49 -92 55
		// String s = "abcd01中文测试";
		// printByte(s,"UTF-8");
		// printByte(s,"UTF-16");
	}

}
