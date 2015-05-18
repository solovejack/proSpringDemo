<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>草稿箱</title>
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
<script language="JavaScript" src="js/main/menu.js"></script>
</head>
<body>
<div class="title"> 
   <img src="images/global/pageicon.jpg" align="middle"/>
   <span id="tname">草稿箱</span>
 </div>
 <div>
  <table class="table" cellpadding="0" cellspacing="0" width="100%">
       <tr>
          <td class="tabSingleHeader">收件人</td>
          <td class="tabSingleHeader">创稿日期</td>
          <td class="tabSingleHeader">标题</td>
          <td class="tabSingleHeader">操作</td>
       </tr>
       <c:forEach items="${mailList}" var="mailList" varStatus="status">
        <tr onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if> <c:if test="${status.count%2!=0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
          <td>${mailList.accepterName}</td>
          <td>${mailList.readDate}</td>
          <td><a href="#" onclick="popQryMail('${mailList.postId}')">${mailList.title}</a></td>
          <td><a href="#" onclick="btnSend('${mailList.postId}')">发送</a>|
          <a href="#" onclick="btnEdit('${mailList.postId}')">编辑</a>|
          <a href="#" onclick="btnDel('${mailList.postId}')">删除</a>
          </td>   
       </tr>
       </c:forEach>
   </table>  
   </div>
</body>
<script type="text/javascript">
/**
 * 发送
 */
function btnSend(postId){
	if(!postId){
		alert("没有主键！");
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
				window.location.reload();
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
 * 编辑
 */
function btnEdit(postId){
	if(!postId){
		alert("没有主键！");
		return;
	}
    //弹出窗口
	var url="oaManage.do?action=popMailEdit&postId="+postId;
	art.dialog.open(url, {
		id : 'popMailEdit',
		width : 1000,
		height : 600,
		title : '邮件编辑'
	});
}

/**
 * 删除
 */
function btnDel(postId){
	if(!postId){
		alert("没有主键！");
		return;
	}
	$.ajax({
		type : "POST",
		data : {"postId":postId},
		dataType : "json",
		url : "/proSpringDemo/oaManage.do?action=mailDel",
		success : function(data, status) {
//			var result = eval("(" + data + ")");
			if (data.result == "Y") {
				alert("删除成功!");
				window.location.reload();
			} else {
				alert("删除失败!");
           	}		
		},
		error : function(data) {
			art.dialog({
				content : '删除失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});
}

/**
 * oa邮件查询pop
 */
function popQryMail(postId){
	if(!postId){
		alert("没有主键！");
		return;
	}
    //弹出窗口
	var url="oaManage.do?action=mailDetail&postId="+postId;
	art.dialog.open(url, {
		id : 'popMailQuery',
		width : 1000,
		height : 500,
		title : '邮件内容'
	});
}
</script>
</html>
