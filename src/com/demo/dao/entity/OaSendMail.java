package com.demo.dao.entity;

import java.io.Serializable;

/**
 * 仓库实体
 * @author lijie
 *
 */
public class OaSendMail implements Serializable {
	private static final long serialVersionUID = 5028503457354744542L;
	
	private String postId;
	private String senderId;
	private String accepterId;
	private String title;
	private String content;
	private String sendDate;
	private String fileId;
	private String readFlag;
	private String readDate;//改为创建日期
	private String sendFlag;
	private String showFlag;
	
	public OaSendMail(){
		this.postId = "";
		this.senderId = "";
		this.accepterId = "";
		this.title = "";
		this.content = "";
		this.sendDate = "";
		this.fileId = "";
		this.readFlag = "";
		this.readDate = "";
		this.sendFlag = "";
		this.showFlag = "";
	}
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getAccepterId() {
		return accepterId;
	}
	public void setAccepterId(String accepterId) {
		this.accepterId = accepterId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(String readFlag) {
		this.readFlag = readFlag;
	}
	public String getReadDate() {
		return readDate;
	}
	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}
	public String getSendFlag() {
		return sendFlag;
	}
	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}
	public String getShowFlag() {
		return showFlag;
	}
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}

}
