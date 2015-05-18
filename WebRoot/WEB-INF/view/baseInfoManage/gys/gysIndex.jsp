<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户信息</title>
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
   <span id="tname">客户信息</span>
 </div>
 <div id="querybar">
   <table  cellpadding="0" cellspacing="0" width="100%">
    <tr>
    <td>
    <form  id="queryForm" name="queryForm" action="/proSpringDemo/gys.do?action=query" method="post">
      <table cellpadding="0" border="0" cellspacing="0" width="100%">
	     <tr>
		      <td width="20%">
		         <span id="label">客户名称:</span>
		      	 <input type="text" name="gysmc" value="${gysmc}" class="" id="gysmc" />   
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
          <td class="tabSingleHeader">客户代码</td>
          <td class="tabSingleHeader">客户名称</td>
          <td class="tabSingleHeader">法人代表</td>
          <td class="tabSingleHeader">联系人</td>
          <td class="tabSingleHeader">联系电话</td>
          <td class="tabSingleHeader">传真号码</td>
          <td class="tabSingleHeader">邮政编码</td>
          <td class="tabSingleHeader">邮箱地址</td>
          <td class="tabSingleHeader">网址</td>
          <td class="tabSingleHeader">企业性质</td>
          <td class="tabSingleHeader">开户银行</td>
          <td class="tabSingleHeader">银行账号</td>
          <td class="tabSingleHeader">税务号</td>
          <td class="tabSingleHeader">区域名称</td>
          <td class="tabSingleHeader">备注</td>
          <td class="tabSingleHeader">单位地址</td>
          <td class="tabSingleHeader">操作</td>
       </tr>
       <c:forEach items="${gyslist}" var="gys" varStatus="status">
        <tr onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if> <c:if test="${status.count%2!=0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
				<td>${gys.gysdm}</td>
				<td>${gys.gysmc}</td>
				<td>${gys.fddb}</td>
				<td>${gys.lxr}</td>
				<td>${gys.lxdh}</td>
				<td>${gys.czhm}</td>
				<td>${gys.yzbm}</td>
				<td>${gys.email}</td>
				<td>${gys.www}</td>
				<td>${gys.qyxzdm}</td>
				<td>${gys.khyh}</td>
				<td>${gys.yhzh}</td>
				<td>${gys.swh}</td>
				<td>${gys.qymc}</td>
				<td>${gys.bz}</td>
				<td>${gys.dwdz}</td>
				<td>
           <a href="#" onclick="btnEdit('${user.gysdm}')">编辑</a>|<a href="#" onclick="btnDel('${user.gysdm}')">删除</a>
           </td>     
       </tr>
       </c:forEach>
   </table> 
   <from id="oprForm" name="oprForm" method="post">
   <input type="hidden" id="flag" name="flag" />
   <input type="hidden" id="gysdm" name="gysdm" />
   </from>  
</body>
<script type="text/javascript">
function btnQuery() {
	window.queryForm.submit();
	return;
}

function btnCreate(){
	//字段太多，做跳转页面
	$("#flag").val("C");
	$("#gysdm").val("");
	oprForm.action = "gys.do?action=editGys";
	oprForm.submit();
}

function btnEdit(gysdm){
    //字段太多，做跳转页面
	$("#flag").val("U");
	$("#gysdm").val(gysdm);
	oprForm.action = "gys.do?action=editGys";
	oprForm.submit();
}

function btnDel(gysdm){
	$.ajax({
		type : "POST",
		data : {"gysdm":gysdm},
		dataType : "json",
		url : "gys.do?action=delGys&gysdm="+gysdm,
		success : function(data, status) {
 			//alert(result);
 			if(data.result == "Y"){
			     window.location.reload();
 			}else{
 				alert("删除失败！");
 			}
		},
		error : function(result) {
			art.dialog({
				content : '删除失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});	
}

</script>
</html>
