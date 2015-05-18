<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>角色权限</title>
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
<style type="text/css">
#querybar{
     height:35px;
}
</style>
</head>
<body>
<div class="title"> 
   <img src="images/global/pageicon.jpg" align="middle"/>
   <span id="tname">角色权限</span>
 </div>
 <div id="querybar">
   <table  cellpadding="0" cellspacing="0" width="100%">
    <tr>
    <td>
    <form  id="queryForm" name="queryForm" action="/proSpringDemo/roleRes.do?action=query" method="post">
      <table cellpadding="0" border="0" cellspacing="0" width="100%">
	     <tr>
		      <td width="20%">
		         <span id="label">角色:</span>
		      	 <input type="text" name="roleId" value="${roleId}" class="" id="roleId" />   
		      	 <input type="button" value="查询" onclick="btnQuery()"/>        
		      </td>
	     </tr>
      </table>
      </form>
   </td>
   </tr>
   </table>
 </div>

  <table class="table" cellpadding="0" cellspacing="0" width="100%">
       <tr>
          <td class="tabSingleHeader">角色</td>
          <td class="tabSingleHeader">操作</td>
       </tr>
       <c:forEach items="${roleList}" var="role" varStatus="status">
        <tr onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if> <c:if test="${status.count%2!=0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
			<td>${role.roleId}</td>
			<td>
           <a href="#" onclick="btnPower('${role.roleId}')">设置权限</a>
           </td>     
       </tr>
       </c:forEach>
   </table>   
</body>
<script type="text/javascript">
function btnQuery() {
	window.queryForm.submit();
	return;
}

function btnPower(roleId){
	art.dialog.open('roleRes.do?action=qryRes&roleId='+roleId, {
		id : 'roleResInfo',
		width : 700,
		height : 600,
		title : '角色权限'
	});
}
</script>
</html>
