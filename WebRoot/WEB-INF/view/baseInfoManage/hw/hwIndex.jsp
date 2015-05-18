<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>货位信息</title>
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
   <span id="tname">货位信息</span>
 </div>
 <div id="querybar">
   <table  cellpadding="0" cellspacing="0" width="100%">
    <tr>
    <td>
    <form  id="queryForm" name="queryForm" action="/proSpringDemo/hw.do?action=query" method="post">
      <table cellpadding="0" border="0" cellspacing="0" width="100%">
	     <tr>
		      <td width="20%">
		         <span id="label">货位名称:</span>
		      	 <input type="text" name="hwmc" value="${hwmc}" class="" id="hwmc" />
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
          <td class="tabSingleHeader">货位代码</td>
          <td class="tabSingleHeader">货位名称</td>
          <td class="tabSingleHeader">仓库名称</td>
          <td class="tabSingleHeader">操作</td>
       </tr>
       <c:forEach items="${hwList}" var="hw" varStatus="status">
        <tr onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if> <c:if test="${status.count%2!=0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
				<td>${hw.hwdm}</td>
				<td>${hw.hwmc}</td>
				<td>${hw.ckmc}</td>
				<td>
           <a href="#" onclick="btnEdit('${hw.hwdm}')">编辑</a>|<a href="#" onclick="btnDel('${hw.hwdm}')">删除</a>
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

function btnCreate(){
	art.dialog.open('hw.do?action=editDetail&flag=c', {
		id : 'hwInfo',
		width : 600,
		height : 200,
		title : '新增仓库'
	});
}

function btnEdit(hwdm){
	var url = "hw.do?action=editDetail&flag=u&hwdm="+hwdm;
	art.dialog.open(url, {
		id : 'hwInfo',
		width : 600,
		height : 200,
		title : '编辑仓库'
	});
}

function btnDel(hwdm){
	$.ajax({
		type : "POST",
		data : {"hwdm":hwdm},
		dataType : "json",
		url : "hw.do?action=delDetail",
		success : function(data) {
			if(data.result == "Y"){
				alert("删除货位成功！");
				window.location.reload();
			}else{
				alert("删除货位失败！");
			}
		},
		error : function(data) {
			art.dialog({
				content : '删除货位失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});	
}
</script>
</html>
