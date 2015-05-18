package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 角色资源实体
 * @author lijie
 *
 */
public class ResCheck extends Resources implements Serializable {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String resCheck;

	public String getResCheck() {
		return resCheck;
	}

	public void setResCheck(String resCheck) {
		this.resCheck = resCheck;
	}
}
