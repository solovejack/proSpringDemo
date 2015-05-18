<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>权限信息</title>
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
<style type="text/css">
#querybar{
     height:35px;
}
</style>
</head>
<body>
<div class="title"> 
   <img src="images/global/pageicon.jpg" align="middle"/>
   <span id="tname">权限信息</span>
 </div>
 <div id="querybar">
   <table  cellpadding="0" cellspacing="0" width="100%">
    <tr>
    <td>
    <form  id="queryForm" name="queryForm" action="/proSpringDemo/resources.do?action=query" method="post">
      <table cellpadding="0" border="0" cellspacing="0" width="100%">
	     <tr>
		      <td width="20%">
		         <span id="label">权限信息:</span>
		      	 <input type="text" name="resIdQry" value="${resIdQry}" class="" id="resIdQry" />   
		      	 <input type="button" value="查询" onclick="btnQuery()"/>  
		      	 <input type="button" value="新增" onclick="btnCreate()"/>           
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
          <td class="tabSingleHeader">权限ID</td>
          <td class="tabSingleHeader">权限描述</td>
          <td class="tabSingleHeader">所属系统</td>
          <td class="tabSingleHeader">备注</td>
          <td class="tabSingleHeader">操作</td>
       </tr>
       <c:forEach items="${reslist}" var="res" varStatus="status">
        <tr onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if> <c:if test="${status.count%2!=0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
          <td>${res.resId}</td>
          <td>${res.resDesc}</td>
          <td>${res.resXtmc}</td>
          <td>${res.bz}</td>
           <td>
           <a href="#" onclick="btnEdit('${res.resId}')">编辑</a>|<a href="#" onclick="btnDel('${res.resId}')">删除</a>
           </td>     
       </tr>
       </c:forEach>
   </table>  
   <form id="frmres" method="post">
     <input type="hidden" id="resId" name="resId"/>
   </form> 
</body>
</html>
