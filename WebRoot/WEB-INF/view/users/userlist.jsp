<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>发件箱</title>
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
<div id="title"> 
   <img src="images/global/pageicon.jpg" align="middle"/>
   <span id="tname">发件箱</span>
 </div>
   <div id="btnlist">
    <ul>
      <li><a onclick=""><img src="images/global/btnNew.jpg" align="middle"/></a></li>
      <li><a onclick=""><img src="images/global/btnEdit.jpg" align="middle"/></a></li>
    </ul>
    </div>
    <form  id="sendForm"  method="post">
      <table cellpadding="0" border="0" cellspacing="0" width="100%">
	     <tr>
		      <td width="20%">
		          <span id="label">发件人:</span>		         
		      </td>		      
		      <td width="20%">
                  <input type="text" value="" id="" name="" />
		      </td> 
	     </tr>
	     <tr>
		      <td width="20%">
		          <span id="label">收件人:</span>
		      </td>	      
		      <td width="20%">
                  <input type="text" value="" id="" name="" />
		      </td> 
	     </tr>
	     <tr>
		      <td width="20%">
		          <span id="label">主题:</span>
		      </td>	      
		      <td width="20%">
                  <input type="text" value="" id="" name="" />
		      </td> 
	     </tr>
	     	     <tr>
		      <td width="20%">
		          <span id="label">内容:</span>
		      </td>	      
		      <td width="20%">
                  <input type="text" value="" id="" name="" />
		      </td> 
	     </tr>
	     	     <tr>
		      <td width="20%">
		          <span id="label">时间:</span>
		      </td>	      
		      <td width="20%">
                  <input type="text" value="" id="" name="" />
		      </td> 
	     </tr>
      </table>
      </form>  
</body>
<script type="text/javascript">
function btnQuery() {
	window.queryForm.submit();
	return;
}

function btnCreate(){
	art.dialog.open('resources.do?action=qryResForm&flag=c', {
		id : 'resInfo',
		width : 400,
		height : 200,
		title : '新增权限'
	});
}

function btnEdit(resId){
	var url = "resources.do?action=qryResForm&flag=u&resId="+resId;
	art.dialog.open(url, {
		id : 'resInfo',
		width : 400,
		height : 200,
		title : '编辑权限'
	});
}

function btnDel(resId){
	var resIdQry = $('#resIdQry').val();
	$.ajax({
		type : "POST",
		data : {"resIdQry":resIdQry},
		dataType : "json",
		url : "resources.do?action=delRes&resId="+resId,
		success : function(result) {
			alert(result);
			window.location.href="/proSpringDemo/resources.do?action=index";
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

function resSave(){
	var flag = $("#flag").val();
	$.ajax({
		type : "POST",
		data : $('#resForm').serialize(),
		dataType : "json",
		url : "/proSpringDemo/resources.do?action=saveRes&flag="+flag,
		success : function(data, status) {
//			var result = eval("(" + data + ")");
			if (data.result == "succ") {			
				var win = art.dialog.open.origin;
				art.dialog.close();
				win.location.reload();
			} else {
				alert("加载失败");
			}
		},
		error : function(data) {
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
