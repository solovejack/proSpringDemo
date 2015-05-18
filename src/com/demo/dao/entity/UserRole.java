package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 用户角色实体
 * @author lijie
 *
 */
public class UserRole implements Serializable {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String userId;
	private String roleId;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
