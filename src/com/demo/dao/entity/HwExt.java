package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 货位补充实体
 * @author lijie
 *
 */
public class HwExt extends Hw implements Serializable  {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String ckmc;

	public String getCkmc() {
		return ckmc;
	}

	public void setCkmc(String ckmc) {
		this.ckmc = ckmc;
	}
}
