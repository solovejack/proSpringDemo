package com.demo.biz;

import java.util.List;
import java.util.Set;

import com.demo.dao.entity.RoleCheck;

public interface IUserRoleService {
	public List<RoleCheck> getRolesByUserId(String userId);
	
	public Set<String> getRoleByUserId(String userId);
	
	public String saveUserRoles(String userId,String roles);
}
