package com.ipinyou.test.service;

import java.io.Serializable;

public class Hello implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1033035610368404830L;

	private String test;

	private String desc;

	private byte priority;

	public Hello() {
		super();
	}

	public Hello(String test, String desc, byte priority) {
		super();
		this.test = test;
		this.desc = desc;
		this.priority = priority;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public byte getPriority() {
		return priority;
	}

	public void setPriority(byte priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "test: "+test+", desc: "+desc +", priority:"+priority;
	}
	
	
}
