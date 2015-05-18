<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>员工维护</title>
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
          <td class="td_label td_star">工号</td>
          <td class="td_content"><input type="text" id="userId" name="userId" value="${user.userId}" <c:if test="${flag == 'u'}">readonly</c:if> /></td>
          <td class="td_label td_star">姓名</td>
          <td class="td_content"><input type="text" id="userName" name="userName" value="${user.userName}"  /></td>
          <td class="td_label td_star">性别</td>
          <td class="td_content"><input type="radio" name="sex" value="男"  <c:if test="${user.sex=='男'}">checked="checked"</c:if> />男<input type="radio" name="sex" value="女" <c:if test="${user.sex=='女'}">checked="checked"</c:if> />女</td>
        </tr>
        <tr> 
          <td class="td_label td_star">单位名称</td>
          <td class="td_content">
          <input type="text" id="dwmc" name="dwmc" value="${user.dwmc}"  readonly/>
          <input type="hidden" id="dwdm" name="dwdm" value="${user.dwdm}" />
          <img class=Icon src="images/main/menuicon.gif" onclick="popDw('dwdm','dwmc')">
          </td>
          <td class="td_label td_star">厂库名称</td>          
          <td class="td_content">
          <input type="text" id="ckmc" name="ckmc" value="${user.ckmc}"  readonly/>
          <input type="hidden" id="ckdm" name="ckdm" value="${user.ckdm}" />
          <img class=Icon src="images/main/menuicon.gif"  onclick="popCk('ckdm','ckmc')">
          </td>
          <td class="td_label td_star">班组名称</td>        
          <td class="td_content">
          <input type="text" id="bzmc" name="bzmc" value="${user.bzmc}"  readonly/>
          <input type="hidden" id="bzdm" name="bzdm" value="${user.bzdm}" />
          <img class=Icon src="images/main/menuicon.gif"  onclick="popBz('bzdm','bzmc')">
          </td>
       </tr>
       <tr>
           <td class="td_label td_star">联系电话</td>
           <td class="td_content">
           <input type="text" id="lxdh" name="lxdh" value="${user.lxdh}"  />
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
	if(!$("#userId").val()){
		alert("员工工号不能为空！");
		return;
	}
	var flag = $("#flag").val();
	$.ajax({
		type : "POST",
		data : $("#form1").serialize(),
		dataType : "json",
		url : "users.do?action=saveUser&flag="+flag,
		success : function(data, status) {
			//alert(result);
			if(data.result == "Y"){
				alert("保存用户成功！");
				//关闭当前窗口，刷新父页面
				var win = art.dialog.open.origin;
				art.dialog.close();
				win.location.reload();
				//window.location.reload();
			}else{
				alert("保存用户失败！");
			}		
		},
		error : function(result) {
			art.dialog({
				content : '保存用户失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});	
}

/**
 * 获取班组信息
 */
function popBz(colBzdm,colBzmc){
	var url="bz.do?action=popInit&colBzdm="+colBzdm+"&colBzmc="+colBzmc;
	art.dialog.open(url, {
		id : 'popBz',
		width : 1000,
		height : 500,
		title : '班组pop'
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

/**
 * 获取单位信息
 */
function popDw(colDwdm,colDwmc){
	var url="dw.do?action=popInit&colDwdm="+colDwdm+"&colDwmc="+colDwmc;
	art.dialog.open(url, {
		id : 'popDw',
		width : 1000,
		height : 500,
		title : '单位pop'
	});
}
</script>
</html>
