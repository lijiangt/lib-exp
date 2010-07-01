import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Pattern p = Pattern.compile("(?:\\D+|<\\d+>)*[!?]");
//		Matcher m = p.matcher("foobar foobar foobar");
//		System.out.println(m.matches());
		
		Pattern p = Pattern.compile("abc|def");
		Matcher m = p.matcher("abdef");
		System.out.println(m.matches());

	}

}
