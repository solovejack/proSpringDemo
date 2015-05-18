package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.biz.IUserRoleService;
import com.demo.biz.IUsersService;
import com.demo.util.JsonView;

@Controller
@RequestMapping("/userRole.do")
@Scope("prototype")
public class UserRoleController {
	
	@Autowired
	private IUsersService usersService;
	
	@Autowired
	private IUserRoleService userRoleService;

	@RequestMapping(params = "action=index")
	public ModelAndView index() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usrlist", usersService.findAllUsers());
		return new ModelAndView("sysManage/F00sm001", map);
	}

	@RequestMapping(params = "action=query")
	public ModelAndView query(String userId) throws Exception {
		System.out.println("userId--"+userId);
		Map<String, Object> map = new HashMap<String, Object>();
		if(userId == null || "".equals(userId)){
			return this.index();
		}else{
			map.put("usrlist", usersService.findUsersByUserId(userId));
			map.put("userId", userId);
		}	
		return new ModelAndView("sysManage/F00sm001", map);
	}
	
	@RequestMapping(params = "action=qryRole")
	public ModelAndView qryRole(String userId) throws Exception {
		System.out.println("userId--"+userId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("role", userRoleService.getRolesByUserId(userId));
		map.put("userId", userId);
		return new ModelAndView("sysManage/F00sm002", map);
	}
	
	@RequestMapping(params = "action=saveUserRole")
	public  JsonView saveUserRole(String userId,String roles) throws Exception {
		System.out.println("userId--"+userId);
		System.out.println("roles--"+roles);
		JsonView view = new JsonView();		
		try {
			view.setProperty("result", userRoleService.saveUserRoles(userId, roles));			
		} catch (Exception ex) {
			ex.printStackTrace();			
			view.setProperty("result", "N");
		}
		return view;
	}
}
