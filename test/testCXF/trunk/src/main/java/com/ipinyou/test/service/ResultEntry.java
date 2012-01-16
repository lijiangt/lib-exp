/**
 * 
 */
package com.ipinyou.test.service;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author lijt
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultEntry")
public class ResultEntry {
	@XmlElement(required = true, nillable = false)
	String key;

	ArrayList<String> value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ArrayList<String> getValue() {
		return value;
	}

	public void setValue(ArrayList<String> value) {
		this.value = value;
	}
}
