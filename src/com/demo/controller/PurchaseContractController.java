package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.base.BaseController;
import com.demo.dao.entity.Users;

@Controller
@RequestMapping("/purchaseContract.do")
@Scope("prototype")
public class PurchaseContractController extends BaseController{
	@RequestMapping(params = "action=contractIndex")
	public ModelAndView contractIndex(HttpServletRequest request
		) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Users user=this.getUser(request);
		return new ModelAndView("purchaseContract/contractIndex", map);
	}
	
}
