package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 仓库实体
 * @author lijie
 *
 */
public class Ck implements Serializable {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String ckdm;
	private String ckmc;
	public String getCkdm() {
		return ckdm;
	}
	public void setCkdm(String ckdm) {
		this.ckdm = ckdm;
	}
	public String getCkmc() {
		return ckmc;
	}
	public void setCkmc(String ckmc) {
		this.ckmc = ckmc;
	}


}
