package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.OaSendMail;
import com.demo.dao.entity.OaSendMailExt;

public interface IOaSendMailDAO {
	public OaSendMail findByPK(String postId);
	
	public String insByPK(OaSendMail oaSendMail);
	
	public String updByPK(OaSendMail oaSendMail);
	
	public String delByPK(String postId);

	public Collection<OaSendMailExt> findSendMailByUserId(String userId);
	
	public Collection<OaSendMailExt> findAcceptMailByUserId(String userId);
	
	public String saveOaSendMail(OaSendMail oaSendMail);
	
	public String sendOaSendMail(OaSendMail oaSendMail);
	
	public Collection<OaSendMailExt> findDraftMailByUserId(String userId);
	
	public OaSendMailExt findExtByPK(String postId);
}
