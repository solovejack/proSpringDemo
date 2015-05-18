<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ERP</title>
<link rel="stylesheet" type="text/css" href="css/global/base.css"/>
<link rel="stylesheet" type="text/css" href="css/main/main.css"/>
<link rel="stylesheet" type="text/css" href="css/main/top.css"/>
<script src="js/global/dialog/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="js/global/dialog/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script src="js/global/jquery/jquery.min.js"></script>
<script language="javascript" src="js/main/top.js"></script>
</head>
<body onload="ShowDateTime();">
	<div id="Head1">
		<div id="Logo">			
			<span style="font-size:25px;color: #FFFFFF;font-weight:900;">新远企业综合协同管理软件</span>
		</div>
		<div class="navr">
			<img src="images/main/top_before.png" class="imgstr" />
			<a onclick="javascript:history.go(1);" class="hrtiltle">前进</a> 
			<img src="images/main/top_back.png" class="imgstr" />
			<a onclick="javascript:history.go(-1);" class="hrtiltle">后退</a>
			
			<img src="images/main/fave.png" class="imgstr" />
			<a onclick="AddFavorite(window.location,document.title)" class="hrtiltle">添加收藏</a> 
			<img src="images/main/home.png" class="imgstr" />
			<a onclick="setHome(this,window.location)" class="hrtiltle">设为主页</a> 
			 			
			<img src="images/main/top_modpwd.png" class="imgstr" />
			<a onclick="changePwd()" class="hrtiltle">修改密码</a> 
			<img src="images/main/top_exit.png" class="imgstr" />
			<a href="/proSpringDemo/" class="exittiltle" target="_parent">退出</a> 
		</div>
		<div class="curtime"><a id="Head1Right_Time"></a></div>
	</div>
	<div id="Head2">
	    <div id="leftMenu">
		  <img onclick="changeLeftMenu()" border="0" id="leftMenu" title="收缩菜单/显示菜单" src="images/main/show.gif" />
		</div>
		<div id="Head2_Awoke">
			<ul id="AwokeNum">
				<li class="Line"></li>
				<li><a target="desktop">当前用户:&nbsp;&nbsp;<font
				color='#EA0000'>${user.userName}</font></a>
				</li>
			</ul>
		</div>
		<div id="Head1Right_Button">
		    <a style="padding-left:0px;" target="portalRight" href="portal.do?action=portalRight">
		       <img width="65" height="20" alt="显示桌面" src="images/main/desktop.gif" />
		    </a>
       </div>
	</div>
</body>
</html>
