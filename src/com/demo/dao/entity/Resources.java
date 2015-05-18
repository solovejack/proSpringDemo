package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 权限实体
 * @author lijie
 *
 */
public class Resources implements Serializable {
	
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String resId;
	private String resDesc;
	private String resForm;
	private String resActionName;
	private String resXtmc;
	private String bz;
	
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getResDesc() {
		return resDesc;
	}
	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}
	public String getResForm() {
		return resForm;
	}
	public void setResForm(String resForm) {
		this.resForm = resForm;
	}
	public String getResActionName() {
		return resActionName;
	}
	public void setResActionName(String resActionName) {
		this.resActionName = resActionName;
	}
	public String getResXtmc() {
		return resXtmc;
	}
	public void setResXtmc(String resXtmc) {
		this.resXtmc = resXtmc;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}



}
