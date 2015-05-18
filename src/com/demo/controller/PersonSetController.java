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

import com.demo.biz.IUsersService;

@Controller
@RequestMapping("/personSet.do")
@Scope("prototype")
public class PersonSetController {

	@Autowired
	private IUsersService usersService;

	@RequestMapping(params = "action=index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView("sysManage/personSet", map);
	}
}
