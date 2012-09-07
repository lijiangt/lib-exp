/**
 * 
 */
package com.ipinyou.test.service;

import java.io.Serializable;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author lijt
 * 
 */
@XmlType
public class Attachment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7547307389743159173L;

	private String title;

	@XmlMimeType("application/octet-stream")
	protected DataHandler fileData;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DataHandler getFile() {
		return fileData;
	}

	public void setFileData(DataHandler fileData) {
		this.fileData = fileData;
	}

}
