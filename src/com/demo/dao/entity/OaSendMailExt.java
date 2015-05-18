package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 仓库实体
 * @author lijie
 *
 */
public class OaSendMailExt extends OaSendMail implements Serializable  {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String senderName;
	private String accepterName;
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getAccepterName() {
		return accepterName;
	}
	public void setAccepterName(String accepterName) {
		this.accepterName = accepterName;
	}
	
}
