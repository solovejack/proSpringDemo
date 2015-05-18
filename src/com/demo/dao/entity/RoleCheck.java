package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 角色实体
 * @author lijie
 *
 */
public class RoleCheck extends Role implements Serializable {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String roleCheck;

	public String getRoleCheck() {
		return roleCheck;
	}

	public void setRoleCheck(String roleCheck) {
		this.roleCheck = roleCheck;
	}
}
