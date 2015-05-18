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
<script language="javascript" src="js/resources/resList.js"></script>

<style type="text/css">
.label{
  text-align:right;
  color:red;
}

.td_input {
   width:90%;
}
</style>
</head>
<body>
 <div >
   <table  cellpadding="1" cellspacing="1" width="100%">
    <tr>
    <td>
    <input type="hidden" name="flag" id="flag" value="${flag}">
    <form  id="resForm" name="resForm"  method="post" >
      <table cellpadding="0" border="0" cellspacing="0" width="100%" >
	     <tr height="25px">	          
	          <td width="20%" class="label"> <span id="label">权限ID:</span></td>
		      <td width="65%"><input type="text" name="resId" value="${res.resId}" class="td_input" id="resId" <c:if test="${flag == 'u'}">readonly</c:if>/>
		      </td>
	     </tr>
	    <tr height="25px">	 
		      <td class="label"><span id="label">权限描述:</span></td>
		      <td><input type="text" name="resDesc" value="${res.resDesc}" class="td_input" id="resDesc" />
		      </td>
	     </tr>
	     <tr height="25px">	 
	          <td class="label"><span id="label">所属系统:</span></td>
		      <td>
		      	 <input type="text" name="resXtmc" value="${res.resXtmc}" class="td_input" id="resXtmc" />
		      </td>
	     </tr>
	     <tr height="25px">	 
	          <td  class="label"><span id="label">备注:</span></td>
		      <td>
		      	 <input type="text" name="bz" value="${res.bz}" class="td_input" id="bz" />            
		      </td>
	     </tr>
	     <tr height="25px">	 
		      <td colspan="2" align="center">
		         <input type="button" value="保存" onclick="resSave()"/> 
		      </td>
	     </tr>
      </table>
      </form>
   </td>
   </tr>
   </table>
 </div>  
</body>
</html>
