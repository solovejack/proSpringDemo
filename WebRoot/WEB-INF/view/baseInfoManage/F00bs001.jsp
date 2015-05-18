<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>员工信息</title>
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
   <span id="tname">员工信息</span>
 </div>
 <div id="querybar">
   <table  cellpadding="0" cellspacing="0" width="100%">
    <tr>
    <td>
    <form  id="queryForm" name="queryForm" action="/proSpringDemo/users.do?action=query" method="post">
      <table cellpadding="0" border="0" cellspacing="0" width="100%">
	     <tr>
		      <td width="20%">
		         <span id="label">员工工号:</span>
		      	 <input type="text" name="userIdQry" value="${userIdQry}" class="" id="userIdQry" />   
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
  <div>
  <table class="table" cellpadding="0" cellspacing="0" width="100%">
       <tr>
          <td class="tabSingleHeader">工号</td>
          <td class="tabSingleHeader">姓名</td>
          <td class="tabSingleHeader">性别</td>
          <td class="tabSingleHeader">单位名称</td>
          <td class="tabSingleHeader">厂库名称</td>
          <td class="tabSingleHeader">班组名称</td>
          <td class="tabSingleHeader">联系电话</td>
          <td class="tabSingleHeader">操作</td>          
       </tr>
       <c:forEach items="${usrlist}" var="user" varStatus="status">
       <tr onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if> <c:if test="${status.count%2!=0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.sex}</td>
				<td>${user.dwmc}</td>
				<td>${user.ckmc}</td>
				<td>${user.bzmc}</td>
				<td>${user.lxdh}</td>
				<td>
           <a href="#" onclick="btnEdit('${user.userId}')">编辑</a>|<a href="#" onclick="btnDel('${user.userId}')">删除</a>
           </td>     
       </tr>
       </c:forEach>
   </table> 
   </div>
</body>
<script type="text/javascript">
/**
 * 查询
 */
function btnQuery() {
	window.queryForm.submit();
	return;
}

/**
 * 新增
 */
function btnCreate(){
	var url = "users.do?action=editUser&flag=c";
	art.dialog.open(url, {
		id : 'userInfo',
		width : 1000,
		height : 500,
		title : '新增用户'
	});
}

/**
 * 编辑
 */
function btnEdit(userId){
	var url = "users.do?action=editUser&flag=u&userId="+userId;
	art.dialog.open(url, {
		id : 'userInfo',
		width : 1000,
		height : 500,
		title : '编辑用户'
	});
}

/**
 * 删除
 */
function btnDel(userId){
	$.ajax({
		type : "POST",
		data : {"userId":userId},
		dataType : "json",
		url : "users.do?action=delUser",
		success : function(data, status) {
			//alert(result);
			if(data.result == "Y"){
				alert("删除用户成功！");
				window.location.reload();
			}else{
				alert("删除用户失败！");
			}		
		},
		error : function(result) {
			art.dialog({
				content : '删除用户失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});	
}

</script>
</html>
