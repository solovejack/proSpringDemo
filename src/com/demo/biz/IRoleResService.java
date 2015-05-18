package com.demo.biz;

import java.util.List;
import java.util.Set;

import com.demo.dao.entity.ResCheck;

public interface IRoleResService {
	public List<ResCheck> getResListByRoleId(String roleId);
	
	public Set<String> getResByRoleId(String roleId);
	
	public String saveRoleRes(String roleId, String resList);
}
