import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;


public class FileEncoding {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		System.out.println(System.getProperty("file.encoding"));
		OutputStreamWriter osw=
		    new OutputStreamWriter(new FileOutputStream("/home/lijt/tmp/中文测试.txt",true));
		System.out.println(osw.getEncoding());
	}

}
