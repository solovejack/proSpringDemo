package com.demo.biz;

import java.util.Collection;

import com.demo.dao.entity.Users;

public interface IUsersService {
	public Users findByPK(String userId);

	public Collection<Users> findAllUsers();
	
	public Collection<Users> findUsersByUserId(String userId);
	
	public String delByPK(String userId);
	
	public String saveUser(Users user,String flag);
}
