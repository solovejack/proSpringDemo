package com.demo.dao.entity;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String usrId;
	private String usrName;
	private String usrPwd;

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPwd() {
		return usrPwd;
	}

	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}

}
