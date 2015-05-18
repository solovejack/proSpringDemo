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
     width:99%;
}

.td_label{
    width:15%;
    text-align: center;
    font-weight: bolder;  
    background-color: skyblue;
    border-bottom: solid #000 1px;
}

.td_content{
    width:35%;
    background-color: aliceblue;
    border: solid #000 1px;
    padding-left: 10px;
}

.td_star{
    color: red;
}
</style>
</head>
<body>
 <div id="querybar">
   <table  cellpadding="0" cellspacing="0" width="99%">
    <tr>
    <td class="td_label td_star">当前角色</td>
    <td class="td_content">
    <span id="roleId">${roleId}</span>  
   </td>
   <td class="td_label td_star">功能区</td>
   <td class="td_content"><input type="button" id="btnSave" value="保存" /></td>
   </tr>
   </table>
 </div>

  <table class="table" cellpadding="0" cellspacing="0" width="99%">
       <tr>
          <td class="tabSingleHeader">勾选区</td>
          <td class="tabSingleHeader">权限</td>
       </tr>
       <c:forEach items="${res}" var="res" varStatus="status">
        <tr onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if> <c:if test="${status.count%2!=0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
			<td><input type="checkbox" name="resId" value="${res.resId}" <c:if test="${res.resCheck == 'Y'}">checked</c:if> /></td>
			<td>${res.resId}</td>   
       </tr>
       </c:forEach>
   </table>   
</body>
<script type="text/javascript">
$(function(){
	$("#btnSave").click(btnSave);
});

function btnSave(){
     //alert($("#roleId").text());
     var resIds = [];
     $("input[name='resId']:checked").each(function () {
    	 resIds.push(this.value);
     });
     $.ajax({
 		type : "POST",
 		data : {"resIds":resIds.join(","),"roleId":$("#roleId").text()},
 		dataType : "json",
 		url : "roleRes.do?action=saveRoleRes",
 		success : function(data, status) {
 			//alert(result);
 			if(data.result == "Y"){
 				alert("保存成功！");
 				//关闭当前窗口，刷新父页面
 				//var win = art.dialog.open.origin;
 				//art.dialog.close();
 				//win.location.reload();
 			}else{
 				alert("保存失败！");
 			}		
 		},
 		error : function(result) {
 			art.dialog({
 				content : '保存失败',
 				id : 'EF893L',
 				title : '错误提示',
 				icon : 'error'
 			});
 		}
 	});	
}
</script>
</html>
