/**
 * 
 */
package com.ipinyou.test.service;

import javax.jws.WebService;
/**
 * @author lijt
 *
 */
@WebService 
public interface HelloWorld {
	Result sayHi(String h);
	Result sayHello(String text,Hello h);
}
