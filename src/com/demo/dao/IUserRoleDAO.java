package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.UserRole;

public interface IUserRoleDAO {

	public Collection<UserRole> findByUserId(String userId);
	
	public String delByUserId(String userId);
	
	public String insByPK(UserRole userRole);
}
