<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>邮件详情</title>
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
    width:100px;
    text-align:center;
    font-weight:bold;
    color:red;
}

.detail_td{
    width:300px;
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
 <div id="form" >
    <form  id="form1" name="form1">
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
		      <td class="detail_td">
		         <span>${mail.accepterName}</span>
		      </td>
	     </tr>
	     <tr>
		      <td class="title_td">
		         <span id="label">主题:</span>          
		      </td>
		      <td class="detail_td">
		         <span>${mail.title}</span>
		      </td>
	     </tr>
	     <tr>
		      <td class="title_td">
		         <span id="label">文件内容:</span>          
		      </td>
		      <td>
		         <textarea id="content" name="content" rows="6" cols="100" readonly="readonly">${mail.content}</textarea>
		      </td>
	     </tr>
	     <tr>
		      <td class="title_td">
		         <span id="label">发件时间:</span>          
		      </td>
		      <td class="detail_td">	      
		         <span id="sendDate" name="sendDate">${mail.sendDate}</span>
		      </td>
	     </tr>
      </table>
      </form>
 </div>  
</body>
<script type="text/javascript">
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
});
</script>
</html>
