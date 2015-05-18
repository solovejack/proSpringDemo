<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>仓库pop</title>
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
 <div id="querybar">
   <table  cellpadding="0" cellspacing="0" width="100%">
    <tr>
    <td>
    <form  id="queryForm" name="queryForm" action="/proSpringDemo/ck.do?action=popQuery" method="post">
      <table cellpadding="0" border="0" cellspacing="0" width="100%">
	     <tr>
		      <td width="20%">
		         <span id="label">仓库名称:</span>
		         <input type="hidden" id="colCkdm" name="colCkdm" value="${colCkdm}"/>
                 <input type="hidden" id="colCkmc" name="colCkmc" value="${colCkmc}"/>
		      	 <input type="text" name="ckmcQry" value="${ckmcQry}" class="" id="ckmcQry" />   
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
       <thead>
       <tr>
          <td class="tabSingleHeader">仓库代码</td>
          <td class="tabSingleHeader">仓库名称</td>
       </tr>
       </thead>
       <tbody>
       <c:forEach items="${cklist}" var="cklist" varStatus="status">
        <tr ondblclick="ckSelect('${cklist.ckdm}','${cklist.ckmc}')"  onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if> <c:if test="${status.count%2!=0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
          <td>${cklist.ckdm}</td>
          <td>${cklist.ckmc}</td>
       </tr>
       </c:forEach>
       </tbody>
   </table> 
</body>
<script type="text/javascript">
function btnQuery() {
	window.queryForm.submit();
	return;
}

function ckSelect(ckdm,ckmc){
	var colCkdm = $("#colCkdm").val();
	var colCkmc = $("#colCkmc").val();
	var win = art.dialog.open.origin;
	art.dialog.close();
	win.document.getElementById(colCkdm).value = ckdm;
	win.document.getElementById(colCkmc).value = ckmc;
}

</script>
</html>
