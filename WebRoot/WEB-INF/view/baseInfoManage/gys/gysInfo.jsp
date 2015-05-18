<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户维护</title>
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
          <td class="td_label td_star">客户代码</td>
          <td class="td_content"><input type="text" id="gysdm" name="gysdm" value="${gys.gysdm}" /></td>
          <td class="td_label td_star">客户名称</td>
          <td class="td_content"><input type="text" id="gysmc" name="gysmc" value="${gys.gysmc}"  /></td>
        </tr>
       <tr>
          <td class="td_label td_star">法人代表</td>
          <td class="td_content"><input type="text" id="fddb" name="fddb" value="${gys.fddb}" /></td>
          <td class="td_label td_star">联系人</td>
          <td class="td_content"><input type="text" id="lxr" name="lxr" value="${gys.lxr}"  /></td>
        </tr>
       <tr>
          <td class="td_label td_star">联系电话</td>
          <td class="td_content"><input type="text" id="lxdh" name="lxdh" value="${gys.lxdh}" /></td>
          <td class="td_label td_star">传真号码</td>
          <td class="td_content"><input type="text" id="czhm" name="czhm" value="${gys.czhm}"  /></td>
        </tr>
       <tr>
          <td class="td_label td_star">邮政编码</td>
          <td class="td_content"><input type="text" id="yzbm" name="yzbm" value="${gys.yzbm}" /></td>
          <td class="td_label td_star">邮箱地址</td>
          <td class="td_content"><input type="text" id="email" name="email" value="${gys.email}"  /></td>
        </tr>
       <tr>
          <td class="td_label td_star">网址</td>
          <td class="td_content"><input type="text" id="www" name="www" value="${gys.www}" /></td>
          <td class="td_label td_star">企业性质</td>
          <td class="td_content"><input type="text" id="qyxzdm" name="qyxzdm" value="${gys.qyxzdm}"  /></td>
        </tr>
       <tr>
          <td class="td_label td_star">开户银行</td>
          <td class="td_content"><input type="text" id="khyh" name="khyh" value="${gys.khyh}" /></td>
          <td class="td_label td_star">银行账号</td>
          <td class="td_content"><input type="text" id="yhzh" name="yhzh" value="${gys.yhzh}"  /></td>
        </tr>
       <tr>
          <td class="td_label td_star">税务号</td>
          <td class="td_content"><input type="text" id="swh" name="swh" value="${gys.swh}" /></td>
          <td class="td_label td_star">区域名称</td>
          <td class="td_content"><input type="text" id="qymc" name="qymc" value="${gys.qymc}"  /></td>
        </tr>
       <tr>
          <td class="td_label td_star">备注</td>
          <td class="td_content"><input type="text" id="bz" name="bz" value="${gys.bz}" /></td>
          <td class="td_label td_star">单位地址</td>
          <td class="td_content"><input type="text" id="dwdz" name="dwdz" value="${gys.dwdz}"  /></td>
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
	if(!$("#gysdm").val()){
		alert("客户代码不能为空！");
		return;
	}
	var flag = $("#flag").val();
	$.ajax({
		type : "POST",
		data : $("#form1").serialize(),
		dataType : "json",
		url : "gys.do?action=saveUser&flag="+flag,
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
