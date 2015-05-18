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

import com.demo.biz.IGysService;

@Controller
@RequestMapping("/gys.do")
@Scope("prototype")
public class GysController {

	@Autowired
	private IGysService gysService;

	@RequestMapping(params = "action=index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gyslist", gysService.findAllGys());
		return new ModelAndView("baseInfoManage/gys/gysIndex", map);
	}
	
	@RequestMapping(params = "action=query")
	public ModelAndView query(HttpServletRequest request,
			HttpServletResponse response,String gysmc) throws Exception {
		System.out.println("gysmc--"+gysmc);
		Map<String, Object> map = new HashMap<String, Object>();
		if(gysmc == null || "".equals(gysmc)){
			return this.index(request, response);
		}else{
			map.put("gyslist", gysService.findGysByGysmc(gysmc));
			map.put("gysmc", gysmc);
		}		
		return new ModelAndView("baseInfoManage/gys/gysIndex", map);
	}
}
