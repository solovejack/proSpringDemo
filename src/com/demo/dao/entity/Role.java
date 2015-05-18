package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 角色实体
 * @author lijie
 *
 */
public class Role implements Serializable {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String roleId;
	private String roleDesc;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
