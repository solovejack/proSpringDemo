package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 单位实体
 * @author lijie
 *
 */
public class Dw implements Serializable {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String dwdm;
	private String dwmc;
	
	public String getDwdm() {
		return dwdm;
	}
	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

}
