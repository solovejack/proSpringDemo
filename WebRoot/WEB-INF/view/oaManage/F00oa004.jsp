<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>已发件</title>
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
<script language="javascript" src="js/resources/resList.js"></script>
</head>
<body>
<div class="title"> 
   <img src="images/global/pageicon.jpg" align="middle"/>
   <span id="tname">已发件</span>
 </div>
 <div>
  <table class="table" cellpadding="0" cellspacing="0" width="100%">
       <tr>
          <td class="tabSingleHeader">收件人</td>
          <td class="tabSingleHeader">发件日期</td>
          <td class="tabSingleHeader">标题</td>
          <td class="tabSingleHeader">状态</td>
       </tr>
       <c:forEach items="${mailList}" var="mailList" varStatus="status">
        <tr onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if> <c:if test="${status.count%2!=0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
          <td>${mailList.accepterName}</td>
          <td>${mailList.sendDate}</td>
          <td><a href="#" onclick="popQryMail('${mailList.postId}')">${mailList.title}</a></td>
          <td><c:if test="${mailList.readFlag=='A'}">未阅</c:if><c:if test="${mailList.readFlag=='B'}">已阅</c:if></td>   
       </tr>
       </c:forEach>
   </table>  
   </div>
</body>
<script type="text/javascript">
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
