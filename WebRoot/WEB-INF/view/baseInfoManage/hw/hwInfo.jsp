<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>货位维护</title>
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

.td_label{
    text-align: center;
    font-weight: bolder;  
    background-color: cadetblue;
    border-bottom: solid #000 1px;
}

.td_content{
    background-color: aliceblue;
}

.td_star{
    color: red;
}
table tbody tr{
    height:30px;
}
</style>
</head>
<body>
  <input type="hidden" name="flag" id="flag" value="${flag}">
  <div>
     <div id="btnlist" style="height:30px;">
    <ul>
      <li><a><input type="button" id="btnSave" name="btnSave" value="保存" /></a></li>
    </ul>
    </div>
  <form  id="form1" name="form1">
  <table cellpadding="0" cellspacing="0" width="100%">
        <tr> 
          <td class="td_label td_star">货位代码</td>
          <td class="td_content"><input type="text" id="hwdm" name="hwdm" value="${hw.hwdm}" <c:if test="${flag == 'u'}">readonly</c:if> /></td>
       </tr>
       <tr>
           <td class="td_label td_star">货位名称</td>
           <td class="td_content">
           <input type="text" id="hwmc" name="hwmc" value="${hw.hwmc}"  />
           </td>
       </tr>
       <tr>
           <td class="td_label td_star">仓库名称</td>
           <td class="td_content">
          <input type="text" id="ckmc" name="ckmc" value="${hw.ckmc}"  readonly/>
          <input type="hidden" id="ckdm" name="ckdm" value="${hw.ckdm}" />
          <img class=Icon src="images/main/menuicon.gif"  onclick="popCk('ckdm','ckmc')">
           </td>
       </tr>
   </table> 
   </form>
   </div>
</body>
<script type="text/javascript">
/**
 * 初始化
 */
$(function(){
	$("#btnSave").click(btnSave);
});
/**
 * 保存
 */
function btnSave(){
	if(!$("#hwdm").val()){
		alert("货物代码不能为空！");
		return;
	}
	var flag = $("#flag").val();
	$.ajax({
		type : "POST",
		data : $("#form1").serialize(),
		dataType : "json",
		url : "hw.do?action=saveDetail&flag="+flag,
		success : function(data, status) {
			//alert(result);
			if(data.result == "Y"){
				alert("保存货位信息成功！");
				//关闭当前窗口，刷新父页面
				var win = art.dialog.open.origin;
				art.dialog.close();
				win.location.reload();
				//window.location.reload();
			}else{
				alert("保存货位信息失败！");
			}		
		},
		error : function(result) {
			art.dialog({
				content : '保存货位信息失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});	
}

/**
 * 获取仓库信息
 */
function popCk(colCkdm,colCkmc){
	var url="ck.do?action=popInit&colCkdm="+colCkdm+"&colCkmc="+colCkmc;
	art.dialog.open(url, {
		id : 'popCk',
		width : 1000,
		height : 500,
		title : '仓库pop'
	});
}
</script>
</html>
