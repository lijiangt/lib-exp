/**
 * 
 */
package com.ipinyou.test.service.impl;

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
	
	

}
