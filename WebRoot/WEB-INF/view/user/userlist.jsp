<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>错误页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="css/global/base.css">
<link rel="stylesheet" type="text/css" href="css/global/table.css">
<script language="JavaScript" src="js/global/jquery.min.js"></script>
<script src="js/global/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script language="JavaScript" src="js/global/bgrow.js"></script>
</head>
<body>
<div id="title"> 
   <img src="images/global/pageicon.jpg" align="middle"/>
   <span id="tname">用户信息</span>
 </div>
 <div id="querybar">
   <table  cellpadding="0" cellspacing="0" width="100%">
    <tr>
      <td style="padding-left:10px;" width="70px;">
        <img src="images/global/query.png" width="60px" height="60px"/>
      </td>
    <td>
    <form  id="queryForm"  method="post">
      <table cellpadding="0" border="0" cellspacing="0" width="100%">
	     <tr>
		      <td width="20%"><span id="label">单位名称:</span>
		        <select name="seqUnitCode" style="width:150px;">                 
                </select>
		      </td>
		      <td width="20%"><span id="label">项目类型:</span>
		        <select name="projectTypeCode" style="width:150px;">
		        <option value="">==全部==</option>		        
		        </select>
		        </select>
		      </td> 
		      <td width="20%"><span id="label">项目性质:</span>
		      <select name="projectNature" style="width:150px;">
		        <option value="">==全部==</option>		        
		        </select>
		      </td>
		      <td width="20%"><span id="label">项目属性:</span>
		      <select name="projectAttr" style="width:150px;">
		        <option value="">==全部==</option>		        
		        </select>
		      </td>
		      <td width="20%" rowspan="2">
		        <a onclick="btnQuery()" style="cursor:hand;"><img src="images/global/btnQuery.jpg"/></a>
		      </td>
	     </tr>
	      <tr>
		      <td><span id="label">开始时间:</span>
		        <input type="text" name="startDate"
					value="${project.startDate}"   style="width:150px;" class="Wdate" id="startDate" onfocus="WdatePicker({el:'startDate',dateFmt:'yyyy-MM-dd'})"/>
		      </td>
		       <td><span id="label">结束时间:</span>
		        <input type="text" name="endDate"
					value="${project.endDate}"  class="Wdate" id="endDate" onfocus="WdatePicker({el:'endDate',dateFmt:'yyyy-MM-dd'})"/>
		      </td>
		       <td><span id="label">项目级次:</span>
		         <select name="projectGrade" style="width:150px;">
		        <option value="">==全部==</option>
		         <c:forEach items="${projectGradeList}" var="item">
			       <option value="${item.dictKey}"  ${project.projectGrade==item.dictKey?"selected":""}>${item.dictName}</option>
		         </c:forEach>
		        </select>
		      </td>
		      <td><span id="label">项目状态:</span>
		        <select name="projectStatus" style="width:150px;">
		           <option value="-2">==全部==</option>         
		        </select>
		      </td>
	     </tr>
      </table>
      </form>
   </td>
   </tr>
   </table>
 </div>
   <div id="btnlist">
    <ul>
      <li><a onclick="funProjectSeq(${page.pageCurrent},${page.pagePerRows})"><img src="images/global/btnNew.jpg" align="middle"/></a></li>
      <li><a onclick="funEditProject(${page.pageCurrent},${page.pagePerRows})"><img src="images/global/btnEdit.jpg" align="middle"/></a></li>
      <li><a onclick="funDelProject()"><img src="images/global/btnDel.jpg" align="middle"/></a></li>
      <li><a onclick="funViewProject(${page.pageCurrent},${page.pagePerRows})"><img src="images/global/btnView.jpg" align="middle"/></a></li>
    </ul>
    </div>
    
  <table class="table" cellpadding="0" cellspacing="0" width="100%">
       <tr>
          <td class="tabSingleHeader">&nbsp;</td>
          <td class="tabSingleHeader">用户编号</td>
          <td class="tabSingleHeader">用户名词</td>
          <td class="tabSingleHeader">用户密码</td>
          <td class="tabSingleHeader">操作</td>                
       </tr>
       <c:forEach items="${usrlist}" var="usr" varStatus="status">
        <tr onmouseover="rowmouseover(this)" <c:if test="${status.count%2==0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if> <c:if test="${status.count%2!=0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
          <td><input type="radio" name="ss"/></td>
          <td>${usr.usrId}</td>
          <td>${usr.usrName}</td>
          <td>${usr.usrPwd}</td>    
           <td><a href="">编辑</a>|<a href="">删除</a></td>     
       </tr>
       </c:forEach>
       <tr>
			<td class="tabFootBg" colspan="5">
			   <input type="hidden" id="page_per_num" value="${page.pagePerRows}"/>
			   <span style="margin-right:20px;">共有&nbsp;&nbsp;<font color="red">${page.totalRowsCount}&nbsp;</font>&nbsp;&nbsp;条信息，每页&nbsp;&nbsp;<font color="red">${page.pagePerRows}</font>&nbsp;&nbsp;条，当前&nbsp;&nbsp;<font color="red">${page.pageCurrent}&nbsp;/&nbsp;${page.totalPageCount}</font>&nbsp;&nbsp;页</span>
			   <span style="padding-right:30px;">
			      <img style="cursor:hand;margin-right:10px;" src="/resource/images/admin/first.gif" onclick="navigationPage('${page.url}',${page.topPageNo},'queryForm')" title="第一页"/>
	              <img style="cursor:hand;margin-right:10px;" src="/resource/images/admin/prev.gif" onclick="navigationPage('${page.url}',${page.previousPageNo},'queryForm')"  title="上一页"/>
	              <img style="cursor:hand;margin-right:10px;" src="/resource/images/admin/next.gif" onclick="navigationPage('${page.url}',${page.nextPageNo},'queryForm')"  title="下一页"/>
	              <img style="cursor:hand;margin-right:10px;" src="/resource/images/admin/last.gif" onclick="navigationPage('${page.url}',${page.bottomPageNo},'queryForm')"  title="最后页"/>
			   </span>
			</td>			
		</tr>
   </table>   
</body>
</html>
