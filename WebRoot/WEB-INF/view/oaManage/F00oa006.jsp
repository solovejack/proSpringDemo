<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>邮件草稿编辑</title>
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
    width:10%;
    text-align:center;
    font-weight:bold;
    color:red;
}

.detail_td{
    width:89%;
}

table tbody tr{
    height:25px;
}

table tr td{
    
}
</style>
</head>
<body>

   <div id="btnlist" style="width:99%;height:30px;">
    <ul>
      <li><a><input type="button" id="btnSave" name="btnSave" value="保存" /></a></li>
    </ul>
    </div>
 
 <div id="form" >
    <form  id="form1" name="form1">
      <input type="hidden" id="postId" name="postId" value="${mail.postId}" />
      <table style="border:1px solid #000;width:80%">
	     <tr>
		      <td class="title_td">
		         <span id="label">发件人:</span>          
		      </td>
		      <td class="detail_td">
		         <span>${mail.senderName}</span>
		      </td>
	     </tr>
	     <tr>
		      <td class="title_td">
		         <span id="label">收件人:</span>          
		      </td>
		      <td>
		         <img class=Icon src="images/main/menuicon.gif" onclick="popUser('accepterId','accepterName')">
		         <span id="accepterName" name="accepterName">${mail.accepterName}</span>
		         <input type="hidden" id="accepterId" name="accepterId" value="${mail.accepterId}"/>
		      </td>
	     </tr>
	     <tr>
		      <td class="title_td">
		         <span id="label">主题:</span>          
		      </td>
		      <td>
		         <input type="text" id="title" name="title" value="${mail.title}" style="width:725px;"/>
		      </td>
	     </tr>
	     <tr>
		      <td class="title_td">
		         <span id="label">文件内容:</span>          
		      </td>
		      <td>
		         <textarea id="content" name="content" rows="6" cols="100">${mail.content}</textarea>
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
 * 保存邮件
 */
function saveMail() {
	//alert("111111111");
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
			url : "/proSpringDemo/oaManage.do?action=popMailSave",
			success : function(data, status) {
//				var result = eval("(" + data + ")");
				if (data.result == "Y") {
					alert("保存成功!");
					//关闭当前窗口，父窗口刷新
					var win = art.dialog.open.origin;
					art.dialog.close();
					win.location.reload();
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
	//按钮绑定事件
	$("#btnSave").click(saveMail);
});
</script>
</html>
