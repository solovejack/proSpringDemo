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

import com.demo.biz.ICkService;
import com.demo.dao.entity.Ck;
import com.demo.util.AssertUtil;
import com.demo.util.JsonView;

@Controller
@RequestMapping("/ck.do")
@Scope("prototype")
public class CkController {

	@Autowired
	private ICkService ckService;

	@RequestMapping(params = "action=index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cklist", ckService.findAllCk());
		return new ModelAndView("baseInfoManage/ck/ckIndex", map);
	}
	
	@RequestMapping(params = "action=query")
	public ModelAndView query(HttpServletRequest request,
			HttpServletResponse response,String ckmc) throws Exception {
		System.out.println("ckmc--"+ckmc);
		Map<String, Object> map = new HashMap<String, Object>();
		if(ckmc == null || "".equals(ckmc)){
			return this.index(request, response);
		}else{
			map.put("cklist",ckService.findCkByCkmc(ckmc));
			map.put("ckmc", ckmc);
		}		
		return new ModelAndView("baseInfoManage/ck/ckIndex", map);
	}
	
	@RequestMapping(params = "action=editCk")
	public ModelAndView editCk(String flag,String ckdm) throws Exception {
		System.out.println("flag--"+flag);
		System.out.println("ckdm--"+ckdm);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		Ck ck = new Ck();
		if("u".equals(flag)){
			ck = ckService.findByPK(ckdm);
		}
		map.put("ck", ck);
		return new ModelAndView("baseInfoManage/ck/ckInfo", map);
	}
	
	@RequestMapping(params = "action=delCk")
	public  JsonView delCk(String ckdm) throws Exception {
		System.out.println("ckdm--"+ckdm);
		JsonView view = new JsonView();		
		try {
			view.setProperty("result", ckService.delByPK(ckdm));			
		} catch (Exception ex) {
			ex.printStackTrace();			
			view.setProperty("result", "N");
		}
		return view;
	}
		
	@RequestMapping(params = "action=saveCk")
	public  JsonView saveCk(String flag,Ck ck) throws Exception {
		System.out.println("flag"+flag);
		JsonView view = new JsonView();		
		try {
			view.setProperty("result", ckService.saveCk(ck, flag));
		} catch (Exception ex) {
			ex.printStackTrace();			
			view.setProperty("result", "N");
		}
		return view;
	}
	
	@RequestMapping(params = "action=popInit")
	public ModelAndView popInit(String colCkdm,String colCkmc) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cklist", ckService.findAllCk());
		map.put("colCkdm", colCkdm);
		map.put("colCkmc", colCkmc);
		return new ModelAndView("common/popCk", map);
	}
	
	@RequestMapping(params = "action=popQuery")
	public ModelAndView popQuery(String ckmcQry,String colCkdm,String colCkmc) throws Exception {
		System.out.println("ckmcQry--"+ckmcQry);
		Map<String, Object> map = new HashMap<String, Object>();
		if(AssertUtil.isInval(ckmcQry)){
			return this.popInit(colCkdm,colCkmc);
		}else{
			map.put("cklist",ckService.findCkByCkmc(ckmcQry));
			map.put("ckmcQry", ckmcQry);
			map.put("colCkdm", colCkdm);
			map.put("colCkmc", colCkmc);
		}		
		return new ModelAndView("common/popCk", map);
	}
}
