package com.demo.biz;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IUsersDAO;
import com.demo.dao.entity.Users;

@Service
public class IUsersServiceImpl implements IUsersService {
	@Autowired
	private IUsersDAO usersDAO;

	@Override
	public Users findByPK(String userId){
        return usersDAO.findByPK(userId);
	}

	@Override
	public Collection<Users> findAllUsers(){
		return usersDAO.findAllUsers();
	}
	
	@Override
	public Collection<Users> findUsersByUserId(String userId){
		return usersDAO.findUsersByUserId(userId);
	}
	
	@Override
	public String delByPK(String userId){
		return usersDAO.delByPK(userId);
	}

	@Override
	public String saveUser(Users user, String flag) {
		// TODO 自动生成的方法存根
		if("u".equals(flag)){
			//保存
			return usersDAO.updByPK(user);
		}else{
			//新增
			return usersDAO.insByPK(user);
		}
	}
}
