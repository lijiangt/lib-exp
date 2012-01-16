package com.ipinyou;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ipinyou.test.service.Hello;
import com.ipinyou.test.service.HelloWorld;
import com.ipinyou.test.service.Result;

/**
 * Hello world!
 * 
 */
public class App {
	
	
	public static void main(String args[]) throws Exception {
		// START SNIPPET: client
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "beans.xml" });

		HelloWorld client = (HelloWorld) context.getBean("client");
		Hello h = new Hello("你好，Silver Lee","CXF Test",(byte)0);
		Result r = client.sayHi("你好，Silver Lee");
		System.out.println("result:" + r.getResult());
		System.out.println("desc:  " + r.getDesc());
		r = client.sayHello("Silver Lee", new Hello("tteesstt","ddeesscc",(byte)5));
		System.out.println("result:" + r.getResult());
		System.out.println("desc:  " + r.getDesc());
		
		HashMap<String,ArrayList<String>> o =client.sayMap("hello");
		for(Map.Entry<String,ArrayList<String>> e:o.entrySet()){
			System.out.println(e.getKey()+": "+e.getValue().size());
		}
		

	}
	

	
}
