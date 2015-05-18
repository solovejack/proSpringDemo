package com.demo.biz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IRoleDAO;
import com.demo.dao.IUserRoleDAO;
import com.demo.dao.entity.Role;
import com.demo.dao.entity.RoleCheck;
import com.demo.dao.entity.UserRole;
import com.demo.util.AssertUtil;

@Service
public class IUserRoleServiceImpl implements IUserRoleService {
	@Autowired
	private IUserRoleDAO userRoleDAO;
	
	@Autowired
	private IRoleDAO roleDAO;

	@Override
    public List<RoleCheck> getRolesByUserId(String userId){
		List<RoleCheck> ret = new ArrayList<RoleCheck>();
		Collection<Role> roleCol = roleDAO.findAll();
		Set<String> roles = this.getRoleByUserId(userId);
		Iterator<Role> it = roleCol.iterator();
		while(it.hasNext()){
			Role role = it.next();
			RoleCheck roleCheck = new RoleCheck();
			roleCheck.setRoleId(role.getRoleId());
			roleCheck.setRoleDesc(role.getRoleDesc());
			if(roles.contains(role.getRoleId())){
				roleCheck.setRoleCheck("Y");
			}else{
				roleCheck.setRoleCheck("N");
			}
			ret.add(roleCheck);
		}
		return ret;
	}
	
	@Override
	public Set<String> getRoleByUserId(String userId){
		Set<String> role = new HashSet<String>();
		Collection<UserRole> userRoleCol = userRoleDAO.findByUserId(userId);
		Iterator<UserRole> it = userRoleCol.iterator();
		while(it.hasNext()){
			UserRole userRole = it.next();
			if(AssertUtil.isVal(userRole.getRoleId())){
				role.add(userRole.getRoleId());
			}
		}
		return role;
	}

	@Override
	public String saveUserRoles(String userId, String roles) {
		// TODO 自动生成的方法存根
		//删除以前的权限
		userRoleDAO.delByUserId(userId);
		//添加最新的权限
		if(AssertUtil.isVal(roles)){
			for(String role : roles.split(",")){
				UserRole userRole = new UserRole();
				userRole.setRoleId(role);
				userRole.setUserId(userId);
				userRoleDAO.insByPK(userRole);
			}
		}
		return "Y";
	}
}
