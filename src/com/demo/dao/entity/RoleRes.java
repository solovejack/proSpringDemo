package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 角色权限实体
 * @author lijie
 *
 */
public class RoleRes implements Serializable {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String resId;
	private String roleId;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}


}
