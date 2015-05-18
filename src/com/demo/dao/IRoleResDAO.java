package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.RoleRes;

public interface IRoleResDAO {
	public Collection<RoleRes> findByRoleId(String roleId);
	
	public String delByRoleId(String roleId);
	
	public String insByPK(RoleRes roleRes);

}
 