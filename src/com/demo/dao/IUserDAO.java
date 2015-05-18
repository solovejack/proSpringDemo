package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.User;

public interface IUserDAO {
	public User findUserByUsrName(String usrName);

	public Collection<User> findAllUsers();
}
