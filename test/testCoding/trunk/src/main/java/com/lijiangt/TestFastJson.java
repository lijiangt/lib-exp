package com.lijiangt;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class TestFastJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,String> m = new LinkedHashMap<String, String>();
		m.put("remark", "备注");
		m.put("C", "0.1212");
		m.put("S", "0.0875");
		m.put("Ca",  "0.0651");
		m.put("Ti", "0.0056");
		String s = JSON.toJSONString(m);
		System.out.println(s);
		@SuppressWarnings("unchecked")
		Map<String,String> m1 = JSON.parseObject(s, HashMap.class);
		System.out.println(m1);
	}

}
