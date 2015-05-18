package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.Role;

public interface IRoleDAO {
	public Collection<Role> findAll();
	
	public Collection<Role> findByRoleId(String roleId);
}
