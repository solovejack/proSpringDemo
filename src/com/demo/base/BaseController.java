package com.demo.base;

import javax.servlet.http.HttpServletRequest;

import com.demo.dao.entity.Users;

public abstract class BaseController {
	public void setUser(HttpServletRequest request,Users user){
		request.getSession().setAttribute("USER", user);		
	}
    public Users getUser(HttpServletRequest request){
     return (Users)request.getSession().getAttribute("USER");
    }
}
