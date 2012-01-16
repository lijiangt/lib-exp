/**
 * 
 */
package com.ipinyou.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author lijt
 *
 */
public class ResultMapAdapter extends
		XmlAdapter<ResultMap, HashMap<String, ArrayList<String>>> {

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public HashMap<String, ArrayList<String>> unmarshal(ResultMap v)
			throws Exception {
		HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
		for(ResultEntry e:v.getEntries()){
			m.put(e.getKey(), e.getValue());
		}
		return m;
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public ResultMap marshal(HashMap<String, ArrayList<String>> v)
			throws Exception {
		ResultMap m = new ResultMap();
		ResultEntry entry = null;
		for(Map.Entry<String,ArrayList<String>> e: v.entrySet()){
			entry = new ResultEntry(); 
			entry.setKey(e.getKey());
			entry.setValue(e.getValue());
			m.getEntries().add(entry);
		}
		return m;
	}

}
