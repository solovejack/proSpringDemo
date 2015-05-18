package com.demo.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.biz.IDwService;
import com.demo.util.AssertUtil;

@Controller
@RequestMapping("/dw.do")
@Scope("prototype")
public class DwController {

	@Autowired
	private IDwService dwService;

	@RequestMapping(params = "action=popInit")
	public ModelAndView popInit(String colDwdm,String colDwmc) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dwlist", dwService.findAllDw());
		map.put("colDwdm", colDwdm);
		map.put("colDwmc", colDwmc);
		return new ModelAndView("common/popDw", map);
	}
	
	@RequestMapping(params = "action=popQuery")
	public ModelAndView popQuery(String dwmcQry,String colDwdm,String colDwmc) throws Exception {
		System.out.println("dwmcQry--"+dwmcQry);
		Map<String, Object> map = new HashMap<String, Object>();
		if(AssertUtil.isInval(dwmcQry)){
			return this.popInit(colDwdm,colDwmc);
		}else{
			map.put("dwlist",dwService.findDwByDwmc(dwmcQry));
			map.put("dwmcQry", dwmcQry);
			map.put("colDwdm", colDwdm);
			map.put("colDwmc", colDwmc);
		}		
		return new ModelAndView("common/popDw", map);
	}
}
