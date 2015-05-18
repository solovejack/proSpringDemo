package com.demo.biz;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IOaSendMailDAO;
import com.demo.dao.entity.OaSendMail;
import com.demo.dao.entity.OaSendMailExt;
import com.demo.util.DateTimeUtil;
import com.demo.util.UtilMethod;

@Service
public class IOaSendMailServiceImpl implements IOaSendMailService {
	@Autowired
	private IOaSendMailDAO oaSendMailDAO;

	@Override
	public OaSendMail findByPK(String postId) {
		// TODO 自动生成的方法存根
		return oaSendMailDAO.findByPK(postId);
	}
	
	@Override
	public OaSendMailExt findExtByPK(String postId) {
		// TODO 自动生成的方法存根
		return oaSendMailDAO.findExtByPK(postId);
	}

	@Override
	public String saveMail(OaSendMail oaSendMail) {
		// TODO 自动生成的方法存根
		oaSendMail.setSendFlag(UtilMethod.SENDFLAG_A);
		oaSendMail.setReadFlag(UtilMethod.READFLAG_A);
		oaSendMail.setReadDate(DateTimeUtil.getCurrentDate());
		oaSendMail.setSendDate("");
		oaSendMail.setShowFlag("");
		return oaSendMailDAO.insByPK(oaSendMail);
	}

	@Override
	public String sendMail(String postId) {
		// TODO 自动生成的方法存根
		OaSendMail oaSendMail = oaSendMailDAO.findByPK(postId);
		oaSendMail.setSendFlag(UtilMethod.SENDFLAG_B);
		oaSendMail.setSendDate(DateTimeUtil.getCurrentDate());
		return oaSendMailDAO.updByPK(oaSendMail);
	}

	@Override
	public String viewMail(String postId) {
		// TODO 自动生成的方法存根
		OaSendMail oaSendMail = oaSendMailDAO.findByPK(postId);
		oaSendMail.setReadFlag(UtilMethod.READFLAG_B);
		return oaSendMailDAO.updByPK(oaSendMail);
	}	
	
	@Override
	public Collection<OaSendMailExt> findSendMail(String userId) {
		// TODO 自动生成的方法存根
		return oaSendMailDAO.findSendMailByUserId(userId);
	}

	@Override
	public Collection<OaSendMailExt> findReceiveMail(String userId) {
		// TODO 自动生成的方法存根
		return oaSendMailDAO.findAcceptMailByUserId(userId);
	}

	@Override
	public Collection<OaSendMailExt> findDraftMail(String userId) {
		// TODO 自动生成的方法存根
		return oaSendMailDAO.findDraftMailByUserId(userId);
	}

	@Override
	public String savePopMail(OaSendMail oaSendMail) {
		// TODO 自动生成的方法存根
		OaSendMail newMail = oaSendMailDAO.findByPK(oaSendMail.getPostId());
		newMail.setReadDate(DateTimeUtil.getCurrentDate());
		newMail.setAccepterId(oaSendMail.getAccepterId());
		newMail.setTitle(oaSendMail.getTitle());
		newMail.setContent(oaSendMail.getContent());
//		newMail.setSendDate("");
//		newMail.setShowFlag("");
		return oaSendMailDAO.updByPK(newMail);
	}
	
	@Override
	public String delMail(String postId) {
		return oaSendMailDAO.delByPK(postId);
	}
}
