package com.ipinyou.test.service;

import java.io.Serializable;

public class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5895232260376061614L;

	private String result;

	private String desc;

	public Result() {
		super();
	}

	public Result(String result, String desc) {
		super();
		this.result = result;
		this.desc = desc;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
