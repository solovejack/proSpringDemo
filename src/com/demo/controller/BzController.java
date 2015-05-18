package com.demo.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.biz.IBzService;
import com.demo.util.AssertUtil;

@Controller
@RequestMapping("/bz.do")
@Scope("prototype")
public class BzController {

	@Autowired
	private IBzService bzService;

	@RequestMapping(params = "action=popInit")
	public ModelAndView popInit(String colBzdm,String colBzmc) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bzlist", bzService.findAllBz());
		map.put("colBzdm", colBzdm);
		map.put("colBzmc", colBzmc);
		return new ModelAndView("common/popBz", map);
	}
	
	@RequestMapping(params = "action=popQuery")
	public ModelAndView popQuery(String bzmcQry,String colBzdm,String colBzmc) throws Exception {
		System.out.println("bzmcQry--"+bzmcQry);
		Map<String, Object> map = new HashMap<String, Object>();
		if(AssertUtil.isInval(bzmcQry)){
			return this.popInit(colBzdm,colBzmc);
		}else{
			map.put("bzlist",bzService.findBzByBzmc(bzmcQry));
			map.put("bzmcQry", bzmcQry);
			map.put("colBzdm", colBzdm);
			map.put("colBzmc", colBzmc);
		}		
		return new ModelAndView("common/popBz", map);
	}
}
