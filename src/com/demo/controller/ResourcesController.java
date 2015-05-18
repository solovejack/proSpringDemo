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

import com.demo.biz.IResourcesService;
import com.demo.dao.entity.Resources;
import com.demo.util.JsonView;

@Controller
@RequestMapping("/resources.do")
@Scope("prototype")
public class ResourcesController {

	@Autowired
	private IResourcesService resourcesService;

	@RequestMapping(params = "action=index")
	public ModelAndView init(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reslist", resourcesService.findAllResources());
		map.put("resIdQry", "");
		return new ModelAndView("resources/reslist", map);
	}
	
	@RequestMapping(params = "action=query")
	public ModelAndView query(HttpServletRequest request,
			HttpServletResponse response,String resIdQry) throws Exception {
		System.out.println("resIdQry--"+resIdQry);
		Map<String, Object> map = new HashMap<String, Object>();
		if(resIdQry == null || "".equals(resIdQry)){
			return this.init(request, response);
		}else{
			map.put("reslist", resourcesService.findResourcesByResId(resIdQry));
			map.put("resIdQry", resIdQry);
		}		
		return new ModelAndView("resources/reslist", map);
	}
	
	@RequestMapping(params = "action=qryResForm")
	public ModelAndView qryResForm(HttpServletRequest request,
			HttpServletResponse responsen,String flag,String resId) throws Exception {
		String resPk=request.getParameter("resId")!=null?new String(request.getParameter("resId").getBytes("ISO-8859-1"),"utf-8") :"";
//		System.out.println("flag=="+flag);
//		System.out.println("resId=="+resId);
//		System.out.println("resPk=="+resPk);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		Resources res = new Resources();
		if("u".equals(flag)){
			res = resourcesService.findByPk(resPk);
		}
		map.put("res", res);
		return new ModelAndView("resources/resInfo", map);
	}
	
	@RequestMapping(params = "action=saveRes")
	public  JsonView saveRes(HttpServletRequest request,
			HttpServletResponse responsen,Resources res,String flag) throws Exception {
		System.out.println("flag=="+flag);
		System.out.println("res.resId=="+res.getResId());
		JsonView view = new JsonView();		
		try {			
			resourcesService.saveRes(res, flag);
			view.setProperty("result", "succ");			
		} catch (Exception ex) {
			ex.printStackTrace();			
			view.setProperty("result", "error");
		}
		return view;
	}
	
	@RequestMapping(params = "action=delRes")
	public  ModelAndView delRes(HttpServletRequest request,
			HttpServletResponse response,String resId)throws Exception {	
		try {	
			resourcesService.delRes(resId);
		} catch (Exception ex) {
			ex.printStackTrace();			
		}
		return this.init(request, response);
	}
}
