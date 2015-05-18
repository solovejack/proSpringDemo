package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.biz.IHwService;
import com.demo.dao.entity.Hw;
import com.demo.dao.entity.HwExt;
import com.demo.util.AssertUtil;
import com.demo.util.JsonView;

@Controller
@RequestMapping("/hw.do")
@Scope("prototype")
public class HwController {

	@Autowired
	private IHwService hwService;

	@RequestMapping(params = "action=index")
	public ModelAndView index() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hwList", hwService.findAllList());
		return new ModelAndView("baseInfoManage/hw/hwIndex", map);
	}
	
	@RequestMapping(params = "action=query")
	public ModelAndView query(String hwmc) throws Exception {
		System.out.println("hwmc--"+hwmc);
		Map<String, Object> map = new HashMap<String, Object>();
		if(AssertUtil.isInval(hwmc)){
			return this.index();
		}else{
			map.put("hwList",hwService.findListByHwmc(hwmc));
			map.put("hwmc", hwmc);
		}		
		return new ModelAndView("baseInfoManage/hw/hwIndex", map);
	}
	
	@RequestMapping(params = "action=editDetail")
	public ModelAndView editDetail(String flag,String hwdm,HttpServletRequest req) throws Exception {
		System.out.println("flag--"+flag);
		System.out.println("hwdm--"+hwdm);
		String hwdmBak=  AssertUtil.isVal(req.getParameter("hwdm"))? new String(req.getParameter("hwdm").getBytes("ISO-8859-1"),"utf-8"):"" ;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		HwExt hw = new HwExt();
		if("u".equals(flag)){
			hw = hwService.findByPK(hwdmBak);
		}
		map.put("hw", hw);
		return new ModelAndView("baseInfoManage/hw/hwInfo", map);
	}
	
	@RequestMapping(params = "action=delDetail")
	public  JsonView delDetail(String hwdm) throws Exception {
		System.out.println("hwdm--"+hwdm);
		JsonView view = new JsonView();		
		try {
			view.setProperty("result", hwService.delByPK(hwdm));			
		} catch (Exception ex) {
			ex.printStackTrace();			
			view.setProperty("result", "N");
		}
		return view;
	}
		
	@RequestMapping(params = "action=saveDetail")
	public  JsonView saveDetail(String flag,Hw hw) throws Exception {
		System.out.println("flag"+flag);
		JsonView view = new JsonView();		
		try {
			view.setProperty("result", hwService.saveHw(hw, flag));
		} catch (Exception ex) {
			ex.printStackTrace();			
			view.setProperty("result", "N");
		}
		return view;
	}
}
