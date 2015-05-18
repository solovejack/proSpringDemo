package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 班组实体
 * @author lijie
 *
 */
public class Bz implements Serializable {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String bzdm;
	private String bzmc;
	public String getBzdm() {
		return bzdm;
	}
	public void setBzdm(String bzdm) {
		this.bzdm = bzdm;
	}
	public String getBzmc() {
		return bzmc;
	}
	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}
}
