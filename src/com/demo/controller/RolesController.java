package com.demo.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.biz.IUsersService;
import com.demo.dao.entity.Users;
import com.demo.util.JsonView;

@Controller
@RequestMapping("/roles.do")
@Scope("prototype")
public class RolesController {

	@Autowired
	private IUsersService usersService;

	@RequestMapping(params = "action=index")
	public ModelAndView index() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usrlist", usersService.findAllUsers());
		return new ModelAndView("baseInfoManage/F00bs001", map);
	}
	
	@RequestMapping(params = "action=query")
	public ModelAndView query(String userIdQry) throws Exception {
		System.out.println("userIdQry--"+userIdQry);
		Map<String, Object> map = new HashMap<String, Object>();
		if(userIdQry == null || "".equals(userIdQry)){
			return this.index();
		}else{
			map.put("usrlist", usersService.findUsersByUserId(userIdQry));
			map.put("userIdQry", userIdQry);
		}		
		return new ModelAndView("baseInfoManage/F00bs001", map);
	}
	
	@RequestMapping(params = "action=editUser")
	public ModelAndView editUser(String flag,String userId) throws Exception {
		System.out.println("flag--"+flag);
		System.out.println("userId--"+userId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		Users user = new Users();
		if("u".equals(flag)){
			user = usersService.findByPK(userId);
		}
		map.put("user", user);
		return new ModelAndView("baseInfoManage/F00bs002", map);
	}
	
	@RequestMapping(params = "action=delUser")
	public  JsonView delUser(String userId) throws Exception {
		System.out.println("userId--"+userId);
		JsonView view = new JsonView();		
		try {
			view.setProperty("result", usersService.delByPK(userId));			
		} catch (Exception ex) {
			ex.printStackTrace();			
			view.setProperty("result", "N");
		}
		return view;
	}
		
	@RequestMapping(params = "action=saveUser")
	public  JsonView saveUser(String flag,Users user) throws Exception {
		System.out.println("flag"+flag);
		JsonView view = new JsonView();		
		try {
			view.setProperty("result", usersService.saveUser(user, flag));
		} catch (Exception ex) {
			ex.printStackTrace();			
			view.setProperty("result", "N");
		}
		return view;
	}
	
	/**
	 * 员工pop页面
	 * @param colUserId
	 * @param colUserName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "action=popInit")
	public ModelAndView popInit(String colUserId,String colUserName) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("colUserId--"+colUserId);
		System.out.println("colUserName--"+colUserName);
		map.put("usrlist", usersService.findAllUsers());
		map.put("userId", colUserId);
		map.put("userName", colUserName);
		return new ModelAndView("common/popUser", map);
	}
	
	@RequestMapping(params = "action=popQuery")
	public ModelAndView popQuery(String userIdQry,String colUserId,String colUserName) throws Exception {
		System.out.println("userIdQry--"+userIdQry);
		Map<String, Object> map = new HashMap<String, Object>();
		if(userIdQry == null || "".equals(userIdQry)){
			return this.popInit(colUserId,colUserName);
		}else{
			map.put("usrlist", usersService.findUsersByUserId(userIdQry));
			map.put("userIdQry", userIdQry);
			map.put("userId", colUserId);
			map.put("userName", colUserName);
		}		
		return new ModelAndView("common/popUser", map);
	}
}
