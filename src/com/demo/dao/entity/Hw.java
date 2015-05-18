package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 货位实体
 * @author lijie
 *
 */
public class Hw implements Serializable {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String ckdm;
	private String hwdm;
	private String hwmc;
	public String getCkdm() {
		return ckdm;
	}
	public void setCkdm(String ckdm) {
		this.ckdm = ckdm;
	}
	public String getHwdm() {
		return hwdm;
	}
	public void setHwdm(String hwdm) {
		this.hwdm = hwdm;
	}
	public String getHwmc() {
		return hwmc;
	}
	public void setHwmc(String hwmc) {
		this.hwmc = hwmc;
	}

}
