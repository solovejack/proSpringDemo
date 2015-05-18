package com.demo.biz;

import java.util.Collection;

import com.demo.dao.entity.OaSendMail;
import com.demo.dao.entity.OaSendMailExt;

public interface IOaSendMailService {
	public OaSendMail findByPK(String postId);

	public String saveMail(OaSendMail oaSendMail);
	
	public String sendMail(String postId);
	
	public Collection<OaSendMailExt> findSendMail(String userId);
	
	public Collection<OaSendMailExt> findReceiveMail(String userId);
	
	public Collection<OaSendMailExt> findDraftMail(String userId);
	
	public OaSendMailExt findExtByPK(String postId);
	
	public String savePopMail(OaSendMail oaSendMail);
	
	public String delMail(String postId);
	
	public String viewMail(String postId);
}
