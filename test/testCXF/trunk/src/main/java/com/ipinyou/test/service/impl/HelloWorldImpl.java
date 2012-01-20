/**
 * 
 */
package com.ipinyou.test.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.jws.WebService;

import com.ipinyou.test.service.Hello;
import com.ipinyou.test.service.HelloWorld;
import com.ipinyou.test.service.Result;

/**
 * @author lijt
 * 
 */
@WebService(endpointInterface = "com.ipinyou.test.service.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	/**
	 * 
	 */
	public HelloWorldImpl() {
	}


	/* (non-Javadoc)
	 * @see com.ipinyou.test.service.HelloWorld#sayHi(java.lang.String)
	 */
	public Result sayHi(String h) {
//		return new Result("Hello " + h.getTest(), h.getDesc());
		System.err.println(h);
		return new Result("Hello " + h, h);
	}


	/* (non-Javadoc)
	 * @see com.ipinyou.test.service.HelloWorld#sayHello(java.lang.String, com.ipinyou.test.service.Hello)
	 */
	public Result sayHello(String text, Hello h) {
		System.err.println(text);
		return new Result("Hello " + text, h.toString());
	}


	/* (non-Javadoc)
	 * @see com.ipinyou.test.service.HelloWorld#sayMap(java.lang.String)
	 */
	@Override
	public HashMap<String, ArrayList<String>> sayMap(String h) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> l = new ArrayList<String>();
		l.add("h: "+h+1);
		l.add("h: "+h+2);
		map.put("hello",l);
		l = new ArrayList<String>();
		l.add("w: "+h+1);
		l.add("w: "+h+2);
		map.put("world",l);
		return map;
	}


	/* (non-Javadoc)
	 * @see com.ipinyou.test.service.HelloWorld#sayTime(java.util.Date)
	 */
	@Override
	public Date sayTime(Date d) {
		return new Date(d.getTime()+3600l*25*1000);
	}


	
	

}
