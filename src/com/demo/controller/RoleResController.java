package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.biz.IRoleResService;
import com.demo.biz.IRoleService;
import com.demo.util.AssertUtil;
import com.demo.util.JsonView;

@Controller
@RequestMapping("/roleRes.do")
@Scope("prototype")
public class RoleResController {
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IRoleResService roleResService;

	@RequestMapping(params = "action=index")
	public ModelAndView index() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//获取所有角色
		map.put("roleList", roleService.findAll());
		return new ModelAndView("sysManage/F00sm003", map);
	}

	@RequestMapping(params = "action=query")
	public ModelAndView query(String roleId) throws Exception {
		System.out.println("roleId--"+roleId);
		Map<String, Object> map = new HashMap<String, Object>();
		if(AssertUtil.isInval(roleId)){
			return this.index();
		}else{
			//根据角色id获取角色信息
			map.put("roleList", roleService.findByRoleId(roleId));
			map.put("roleId", roleId);
		}	
		return new ModelAndView("sysManage/F00sm003", map);
	}
	
	@RequestMapping(params = "action=qryRes")
	public ModelAndView qryRes(String roleId,HttpServletRequest req) throws Exception {
		String roleIdBak =  AssertUtil.isVal(req.getParameter("roleId"))? new String(req.getParameter("roleId").getBytes("ISO-8859-1"),"utf-8"):"" ;
		System.out.println("roleIdBak--"+roleIdBak);
		Map<String, Object> map = new HashMap<String, Object>();
		//根据角色id获取权限信息
		map.put("res", roleResService.getResListByRoleId(roleIdBak));
		map.put("roleId", roleIdBak);
		return new ModelAndView("sysManage/F00sm004", map);
	}
	
	@RequestMapping(params = "action=saveRoleRes")
	public  JsonView saveRoleRes(String roleId,String resIds) throws Exception {
		System.out.println("roleId--"+roleId);
		System.out.println("resIds--"+resIds);
		JsonView view = new JsonView();
		try {
			//保存角色权限信息
			view.setProperty("result", roleResService.saveRoleRes(roleId, resIds));			
		} catch (Exception ex) {
			ex.printStackTrace();			
			view.setProperty("result", "N");
		}
		return view;
	}
}
