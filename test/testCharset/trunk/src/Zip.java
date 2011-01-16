import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/**
 * 
 */

/**
 * @author lijt
 * 
 */
public class Zip {

	/**
	 * 
	 */
	public Zip() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int BUFFER = 1024;
			ZipOutputStream zos;

			zos = new ZipOutputStream(new CheckedOutputStream(
					new FileOutputStream("/tmp/test.zip"), new CRC32()));
//			zos.setEncoding("UTF-8");
			zos.setEncoding("GBK");
			ZipEntry ze = null;
			byte[] buf = new byte[BUFFER];
			int readLen = 0;

			// ze = new ZipEntry(new String("中文1.properties".getBytes(),"GBK"));
			ze = new ZipEntry("路径1/中文1.properties");
			File f = new File("/home/lijt/build.properties");
			ze.setSize(f.length());
			ze.setTime(f.lastModified());
			zos.putNextEntry(ze);
			InputStream is = new BufferedInputStream(new FileInputStream(f));
			while ((readLen = is.read(buf, 0, BUFFER)) != -1) {
				zos.write(buf, 0, readLen);
			}
			is.close();
			// ze = new ZipEntry(new String("中文2.txt".getBytes(),"GBK"));
			ze = new ZipEntry("路径2/中文2.log");
			f = new File("/home/lijt/velocity.log");
			ze.setSize(f.length());
			ze.setTime(f.lastModified());
			zos.putNextEntry(ze);
			is = new BufferedInputStream(new FileInputStream(f));
			readLen = 0;
			while ((readLen = is.read(buf, 0, BUFFER)) != -1) {
				zos.write(buf, 0, readLen);
			}
			is.close();
			zos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
