<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>发件箱</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="css/global/base.css">
<link rel="stylesheet" type="text/css" href="css/global/table.css">
<script language="JavaScript" src="js/global/jquery/jquery.min.js"></script>
<script src="js/global/dialog/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="js/global/dialog/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script src="js/global/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script language="JavaScript" src="js/global/bgrow.js"></script>
<style type="text/css">
.title_td{
    width:5%;
    text-align:center;
}

table tbody tr{
    height:25px;
}

table tr td{
    
}
</style>
</head>
<body>
<input type="hidden" id="postId" name="postId" value="" />
<div class="title"> 
   <img src="images/global/pageicon.jpg" align="middle"/>
   <span id="tname">发件箱</span>
 </div>
   <div id="btnlist" style="height:30px;">
    <ul>
      <li><a><input type="button" id="btnCreate" name="btnCreate" value="新增" /></a></li>
      <li><a><input type="button" id="btnSave" name="btnSave" value="保存" /></a></li>
      <li><a><input type="button" id="btnDel" name="btnDel" value="发送" /></a></li>
    </ul>
    </div>
 
 <div id="form" >
    <form  id="form1" name="form1">
      <table style="border:1px solid #000;width:80%">
	     <tr>
		      <td class="title_td">
		         <span id="label">发件人:</span>          
		      </td>
		      <td style="width:300px;">
		         <span>${user.userName}</span>	         
		      </td>
	     </tr>
	     <tr>
		      <td class="title_td">
		         <span id="label">收件人:</span>          
		      </td>
		      <td>
		         <img class=Icon src="images/main/menuicon.gif" onclick="popUser('accepterId','accepterName')">
		         <span id="accepterName" name="accepterName"></span>
		         <input type="hidden" id="accepterId" name="accepterId" value=""/>
		      </td>
	     </tr>
	     <tr>
		      <td class="title_td">
		         <span id="label">主题:</span>          
		      </td>
		      <td>
		         <input type="text" id="title" name="title" value="" style="width:725px;"/>
		      </td>
	     </tr>
	     <tr>
		      <td class="title_td">
		         <span id="label">文件内容:</span>          
		      </td>
		      <td>
		         <textarea id="content" name="content" rows="6" cols="100"></textarea>
		      </td>
	     </tr>
	     <tr>
		      <td class="title_td">
		         <span id="label">发件时间:</span>          
		      </td>
		      <td>	      
		         <span id="sendDate" name="sendDate"></span>
		      </td>
	     </tr>
      </table>
      </form>
 </div>  
</body>
<script type="text/javascript">
/**
 * 创建邮件
 */
function createMail(){
	$("#form1")[0].reset();
}

/**
 * 保存邮件
 */
function saveMail() {
	//非空判断
	//判断人员id是否存在
	if(!$("#accepterId").val()){
	    alert("请选择收件人!");
		return;
	}
	if(!$("#title").val()){
	    alert("标题不能为空!");
		return;
	}
		$.ajax({
			type : "POST",
			data : $('#form1').serialize(),
			dataType : "json",
			url : "/proSpringDemo/oaManage.do?action=mailSave",
			success : function(data, status) {
//				var result = eval("(" + data + ")");
				if (data.result == "Y") {
					$("#postId").val(data.postId);
					alert("保存成功!");
					//发送按钮变亮，保存按钮变灰
					$("#btnSave").attr('disabled',"true");
					$("#btnDel").removeAttr("disabled");
				} else {
					alert("保存失败!");
               	}
			},
			error : function(data) {
				art.dialog({
					content : '保存失败',
					id : 'EF893L',
					title : '错误提示',
					icon : 'error'
				});
			}
		});
}

/**
 * 发送邮件
 */
function sendMail() {
	var postId = $("#postId").val();
	if(!postId){
		alert("请先保存！");
		return;
	}
	$.ajax({
		type : "POST",
		data : {"postId":postId},
		dataType : "json",
		url : "/proSpringDemo/oaManage.do?action=mailSend",
		success : function(data, status) {
//			var result = eval("(" + data + ")");
			if (data.result == "Y") {
				alert("发送成功!");
				//保存按钮变亮，发送按钮变灰
				$("#btnDel").attr('disabled',"true");
				$("#btnSave").removeAttr("disabled");
			} else {
				alert("发送失败!");
           	}
		},
		error : function(data) {
			art.dialog({
				content : '保存失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});
}

/**
 * 获取收件人信息
 */
function popUser(colUserId,colUserName){
	var url="users.do?action=popInit&colUserId="+colUserId+"&colUserName="+colUserName;
	art.dialog.open(url, {
		id : 'popUser',
		width : 1000,
		height : 500,
		title : '员工pop'
	});
}

/**
 * 获取当前日期
 */
function getYYMMDD(){
	var myDate=new Date();
	return myDate.toLocaleDateString();
}

/**
 * 初始化
 */
$(function(){
	//显示当前时间
	$("#sendDate").text(getYYMMDD());
	//初始化按钮(发送按钮变灰)
	$("#btnDel").attr('disabled','true');
	//按钮绑定时间
	$("#btnCreate").click(createMail);	
	$("#btnSave").click(saveMail);	
	$("#btnDel").click(sendMail);	
});
</script>
</html>
