import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileEncoding {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException,
			FileNotFoundException {
		System.out.println(System.getProperty("file.encoding"));
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
				"/home/lijt/tmp/中文测试.txt", true));
		System.out.println(osw.getEncoding());
		File in = new File("/home/lijt/tmp/中文测试.txt");
		InputStreamReader r = new InputStreamReader(new FileInputStream(in));
		System.out.println(r.getEncoding());
	}

}
