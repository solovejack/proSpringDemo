<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Spring Demo</title>
<link rel="stylesheet" type="text/css" href="css/global/base.css">
<link rel="stylesheet" type="text/css" href="css/logo/index.css">
<script type="text/javascript" src="js/logo/index.js"></script>
</head>
<body>
	<div id="logo">
	  <form name="frmLogo" action="/proSpringDemo/portal.do?action=validate" method="post" onSubmit="return logoValidate()">
	   <div class="t1">
	     <span>用户名：</span>
	     <span>
	        <input type="text" name="usrName" value="" style="width:150px;"/>
	     </span>
	   </div>
	   <div class="t1">
	     <span>密&nbsp;&nbsp;&nbsp;码 ：</span>
	     <span>
	        <input type="password" name="usrPwd" value="" style="width:150px;"/>
	     </span>
	   </div>
	    <div class="t1">
	      <input type="submit" value="登陆"/>
	   </div>
	   </form>
	</div>
</body>
</html>
