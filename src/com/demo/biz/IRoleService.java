package com.demo.biz;

import java.util.Collection;

import com.demo.dao.entity.Role;

public interface IRoleService {

	public Collection<Role> findAll();
	
	public Collection<Role> findByRoleId(String roleId);
}
