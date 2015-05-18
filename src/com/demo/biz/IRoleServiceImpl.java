package com.demo.biz;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IRoleDAO;
import com.demo.dao.entity.Role;

@Service
public class IRoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleDAO roleDAO;

	@Override
	public Collection<Role> findAll() {
		// TODO 自动生成的方法存根
		return roleDAO.findAll();
	}

	@Override
	public Collection<Role> findByRoleId(String roleId) {
		// TODO 自动生成的方法存根
		return roleDAO.findByRoleId(roleId);
	}

}
