/**
 * 
 */
package com.ipinyou.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author lijt
 * 
 */
@XmlType(name = "ResultMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultMap {
	@XmlElement(nillable = false, name = "entry")
	List<ResultEntry> entries = new ArrayList<ResultEntry>();

	/**
	 * 
	 * @return the entries
	 */

	public List<ResultEntry> getEntries() {
		return entries;

	}

}
