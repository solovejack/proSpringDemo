package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.base.BaseController;
import com.demo.biz.IUserValidate;
import com.demo.biz.IUsersService;
import com.demo.dao.entity.Users;

@Controller
@RequestMapping("/portal.do")
@Scope("prototype")
public class PortalController extends BaseController{

	@Autowired
	private IUserValidate userValidate;
	
	@Autowired
	private IUsersService usersService;

	@RequestMapping(params = "action=validate")
	public ModelAndView validate(HttpServletRequest request,
			HttpServletResponse response, String usrName, String usrPwd)
			throws Exception {
		Users user=usersService.findByPK(usrName);
		if (userValidate.userValidate(user.getPassword(), usrPwd)) {
			this.setUser(request, user);
			return this.index(request, response,usrName);
		} else {
			throw new RuntimeException("登陆异常");
		}
	}

	/**
	 * 软件主界面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "action=index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response,String userId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//传递到主界面
		map.put("userId", userId);
		return new ModelAndView("portal/portalIndex", map);
	}

	/**
	 * 前台管理顶部
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "action=portalTop")
	public ModelAndView portalTop(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("user", this.getUser(request));
		return new ModelAndView("portal/portalTop", map);
	}

	/**
	 * 前台管理左边菜单
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "action=portalLeft")
	public ModelAndView portalBottom(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView("portal/portalLeft", map);
	}

	/**
	 * 前台管理用户桌面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "action=portalRight")
	public ModelAndView portalleft(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView("portal/portalRightBak", map);
	}
}
