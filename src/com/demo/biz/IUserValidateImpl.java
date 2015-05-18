package com.demo.biz;

import org.springframework.stereotype.Service;

@Service
public class IUserValidateImpl implements IUserValidate {

	@Override
	public boolean userValidate(String dbPwd, String usrPwd) {
		return dbPwd.equals(usrPwd);
	}
	

}
