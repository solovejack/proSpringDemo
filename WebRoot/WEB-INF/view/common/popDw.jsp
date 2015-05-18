<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>单位pop</title>
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
    <form  id="queryForm" name="queryForm" action="/proSpringDemo/dw.do?action=popQuery" method="post">
      <table cellpadding="0" border="0" cellspacing="0" width="100%">
	     <tr>
		      <td width="20%">
		         <span id="label">单位名称:</span>
		         <input type="hidden" id="colDwdm" name="colDwdm" value="${colDwdm}"/>
                 <input type="hidden" id="colDwmc" name="colDwmc" value="${colDwmc}"/>
		      	 <input type="text" name="dwmcQry" value="${dwmcQry}" class="" id="dwmcQry" />   
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
          <td class="tabSingleHeader">单位代码</td>
          <td class="tabSingleHeader">单位名称</td>
       </tr>
       </thead>
       <tbody>
       <c:forEach items="${dwlist}" var="dwlist" varStatus="status">
        <tr ondblclick="dwSelect('${dwlist.dwdm}','${dwlist.dwmc}')"  onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if> <c:if test="${status.count%2!=0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
          <td>${dwlist.dwdm}</td>
          <td>${dwlist.dwmc}</td>
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

function dwSelect(dwdm,dwmc){
	var colDwdm = $("#colDwdm").val();
	var colDwmc = $("#colDwmc").val();
	var win = art.dialog.open.origin;
	art.dialog.close();
	win.document.getElementById(colDwdm).value = dwdm;
	win.document.getElementById(colDwmc).value = dwmc;
}

</script>
</html>
