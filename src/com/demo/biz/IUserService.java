package com.demo.biz;

import java.util.Collection;

import com.demo.dao.entity.User;

public interface IUserService {
	public Collection<User> findAllUser();
}
