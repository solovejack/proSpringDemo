package com.demo.biz;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IUserDAO;
import com.demo.dao.entity.User;

@Service
public class IUserServiceImpl implements IUserService {
	@Autowired
	private IUserDAO userDAO;

	@Override
	public Collection<User> findAllUser() {
		return userDAO.findAllUsers();
	}

}
