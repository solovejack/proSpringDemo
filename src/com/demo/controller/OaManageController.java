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
import com.demo.biz.IOaSendMailService;
import com.demo.dao.entity.OaSendMail;
import com.demo.dao.entity.OaSendMailExt;
import com.demo.dao.entity.Users;
import com.demo.util.JsonView;
import com.demo.util.UtilMethod;

@Controller
@RequestMapping("/oaManage.do")
@Scope("prototype")
public class OaManageController extends BaseController {

	@Autowired
	private IOaSendMailService oaSendMailService;

	@RequestMapping(params = "action=mailInit")
	public ModelAndView mailInit(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = this.getUser(request);
		map.put("user", user);
		return new ModelAndView("oaManage/F00oa001", map);
	}
	
	@RequestMapping(params = "action=mailSave")
	public JsonView mailSave(HttpServletRequest request,
			HttpServletResponse response,OaSendMail oaSendMail) throws Exception {
		Users user = this.getUser(request);
		String uuid = UtilMethod.getUUID();
		oaSendMail.setSenderId(user.getUserId());
		oaSendMail.setPostId(uuid);
		JsonView view = new JsonView();
		view.setProperty("result", oaSendMailService.saveMail(oaSendMail));
		view.setProperty("postId", uuid);
		return view;
	}
	
	@RequestMapping(params = "action=mailSend")
	public JsonView mailSend(HttpServletRequest request,
			HttpServletResponse response,String postId) throws Exception {
		JsonView view = new JsonView();			
		view.setProperty("result", oaSendMailService.sendMail(postId));
		return view;
	}
	
	/**
	 * 收件箱
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "action=mailReceiveList")
	public ModelAndView mailReceiveList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mailList", oaSendMailService.findReceiveMail(this.getUser(request).getUserId()));
		return new ModelAndView("oaManage/F00oa002", map);
	}
	
	@RequestMapping(params = "action=mailDraftList")
	public ModelAndView mailDraftList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mailList", oaSendMailService.findDraftMail(this.getUser(request).getUserId()));
		return new ModelAndView("oaManage/F00oa003", map);
	}
	
	@RequestMapping(params = "action=mailSendList")
	public ModelAndView mailSendList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mailList", oaSendMailService.findSendMail(this.getUser(request).getUserId()));
		return new ModelAndView("oaManage/F00oa004", map);
	}
	
	@RequestMapping(params = "action=mailDetail")
	public ModelAndView mailDetail(String postId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mail", oaSendMailService.findExtByPK(postId));
		return new ModelAndView("oaManage/F00oa005", map);
	}
	
	@RequestMapping(params = "action=popMailEdit")
	public ModelAndView popMailEdit(HttpServletRequest request,String postId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		OaSendMailExt mail = oaSendMailService.findExtByPK(postId);
		map.put("mail", mail);
		return new ModelAndView("oaManage/F00oa006", map);
	}
	
	@RequestMapping(params = "action=popMailSave")
	public JsonView popMailSave(HttpServletRequest request,
			HttpServletResponse response,OaSendMail oaSendMail) throws Exception {
		JsonView view = new JsonView();
		view.setProperty("result", oaSendMailService.savePopMail(oaSendMail));
		return view;
	}
	
	@RequestMapping(params = "action=mailDel")
	public JsonView mailDel(HttpServletRequest request,
			HttpServletResponse response,String postId) throws Exception {
		JsonView view = new JsonView();
		view.setProperty("result", oaSendMailService.delMail(postId));
		return view;
	}	
	
	@RequestMapping(params = "action=mailView")
	public JsonView mailDel(String postId) throws Exception {
		JsonView view = new JsonView();
		view.setProperty("result", oaSendMailService.viewMail(postId));
		return view;
	}	
	
}
