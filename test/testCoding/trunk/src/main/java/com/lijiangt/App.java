package com.lijiangt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		// System.out.println("rQ".hashCode());
		// System.out.println("qp".hashCode());
		// System.out.println("s2".hashCode());
		// // Map<Integer,String> m = new HashMap<Integer,String>();
		// // for(char i = 32;i<127;i++){
		// // System.out.print("char: "+i);
		// // System.out.println(" hash: "+(""+i).hashCode());
		// // }
		// String str = null;
		// for(char i = 32;i<127;i++){
		// for(char j = 32;j<127;j++){
		// for(char k = 32;k<127;k++){
		// str = ""+i+j+k;
		// if(str.hashCode()==3615){
		// System.out.println(str);
		// }
		// }
		// }
		// }
//		System.out.println(" ".hashCode());
//		System.out.println("  ".hashCode());
//		System.out.println("   ".hashCode());
//		for(String str:s){
//			System.out.println(str.hashCode());
//		}
		int n = 5;
		if(args.length==1){
			n = Integer.parseInt(args[0]);
		}
		testTime(n);
	}
	
	private static void testTime(int n){
		List<String> l = composite(n);
		Map<String,Integer> m = new HashMap<String,Integer>();
		long start = System.currentTimeMillis();
		for(String s:l){
			m.put(s, 0);
		}
		System.out.println("Put To Map Count: "+(0.0+System.currentTimeMillis()-start)/1000);
		start = System.currentTimeMillis();
		Integer i = m.get(l.get(l.size()-1));
		System.out.println("Get Form Map Count: "+(0.0+System.currentTimeMillis()-start)/1000);
	}
	
	private static void print(int n){
		List<String> l = composite(n);
		int hash = l.get(0).hashCode();
		boolean first = true;
		for(String str:l){
			if(str.hashCode()!=hash){
				throw new IllegalStateException();
			}
//			System.out.println("<input name=\""+str+"\" value=\"0\" type=\"hidden\"/>");
			if(first){
				first = false;
				System.out.print("		  data:'"+str+"=x");
			}else{
				System.out.print("&"+str+"=5");
			}
		}
		System.out.print("',");
		System.out.println();
		System.err.println("Hash: "+hash);
		System.err.println("Size: "+l.size());
		System.err.println("Lenth: "+l.size()*(l.get(0).length()+3));
	}
	
//	static String[] s = new String[]{ "qp", "rQ","s2"};
	static String[] s = new String[]{ "3!", "2@","1_","0~"};
//	static String[] s = new String[]{"};!","|Z!","{y!","}:@","|Y@","{x@","}9_","|X_","{w_","}8~","|W~","{v~"};
	private static List<String> composite(int n){
		if(n==1){
			return Arrays.asList(s);
		}else{
			List<String> ar = new ArrayList<String>();
			for(byte b=0;b<s.length;b++){
				for(String str:composite(n-1)){
					ar.add(s[b]+str);
				}
			}
			return ar;
		}
	}
}
