<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>错误页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="css/global/base.css">
<link rel="stylesheet" type="text/css" href="css/global/table.css">
</head>
<body>
<%Exception ex=(Exception)request.getAttribute("ex");%>
<div id="title"> 
   <img src="images/global/pageicon.jpg" align="middle"/>
   <span id="tname">错误页面</span>
 </div>
 <div id="querybar">
   <table  cellpadding="0" cellspacing="0" width="100%">
    <tr>
      <td style="padding-left:10px;" width="70px;">
        <img src="images/global/error.png" width="60px" height="60px"/>
      </td>
    <td>
      <h2 style="padding-top:15px;"><font color="red">数据库操作错误:SQLException</font></h2>
   </td>
   </tr>
   </table>
 </div>
 <div style="margin-left:50px;">
  <span>
     <h2 style="padding-top:15px;"><font color="red">错误描述：</font></h2>
  </span>
    <ul>
      <li class="id">
         <%= ex.getMessage()%>
      </li>
      <li class="id">
                 数据库操作错误
      </li>
    </ul>
    <span>
     <h2 style="padding-top:15px;"><font color="red">解决办法：</font></h2>
  </span>
    <ul>
      <li id="label">
         确保您输入的信息符合业务的要求，输入信息合法；
      </li>
      <li id="label">
         关闭当前操作的页面，重新点击连接打开；
      </li>
      <li id="label">
         以上办法不能解决，请联系系统管理员；
      </li>
    </ul>
 </div>
</body>
</html>
