package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.Users;

public interface IUsersDAO {
	public Users findByPK(String userId);

	public Collection<Users> findAllUsers();
	
	public Collection<Users> findUsersByUserId(String userId);
	
	public String delByPK(String userId) ;
	
	public String insByPK(Users user);
	
	public String updByPK(Users user);
}
