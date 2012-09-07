/**
 * 
 */
package com.ipinyou.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/**
 * @author lijt
 *
 */
@WebService 
public interface HelloWorld {
	Result sayHi(String h);
	Result sayHello(String text,Hello h);
	
	@XmlJavaTypeAdapter(ResultMapAdapter.class)
	HashMap<String,ArrayList<String>> sayMap(String h);
	
	Date sayTime(Date d);
	
	String uploadAttachment(Attachment a);
}
