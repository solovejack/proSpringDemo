<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ERP</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css"	href="css/global/base.css">
<link rel="stylesheet" type="text/css"	href="css/main/menu.css">
<script language="JavaScript" src="js/main/menu.js"></script>
</head>
<body>
	<div id="Menu">
		<ul id="MenuUl">			
			<li class="level1">
			    <div class="level1Style" id="MEMU_170" onclick="menuClick(this);">
					<img class=Icon src="images/main/menuicon.gif">项目管理
				</div>				
				<ul class="MenuLevel2" id="MEMU_170d" style="display:none">				    
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_17001" onclick="actionPage('/proSpringDemo/user.do?action=index','desktop');">
							 <img src="images/main/menu_arrow_single.gif">用户信息
						  </div>  
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_17003" onclick="actionPage('/projectWebApp/projectSort.do?action=sortUnitIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">单位申报
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_17005" onclick="actionPage('/projectWebApp/projectCheck.do?action=projectCheckIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">项目审批
						  </div>  						 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_17007" onclick="actionPage('/projectWebApp/projectSort.do?action=sortFinalIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">项目入库
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_17009" onclick="actionPage('/projectWebApp/projectQuery.do?action=findUnitSubmitProjectList','desktop');">
							 <img src="images/main/menu_arrow_single.gif">项目查询
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_17011" onclick="actionPage('/projectWebApp/projectBudget.do?action=projectBudgetIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">预算编制
						  </div>  
					</li>					
				    <li class="level2">							
						   <div class="level2Style" id="MEMU_FUNC17013" onclick="subMenuClick(this);">
							  <img id="MEMU_FUNC17013_img" src="images/main/menu_arrow_close.gif">项目变更
						   </div>
						   <ul class="MenuLevel2" id="MEMU_FUNC17013d" style="display:none">
						        <li  id="MEMU_FUNC17015" class="level3Head" onclick="actionPage('/projectWebApp/projectManage.do?action=modOnlineProjectindex&curPage=1&pageRows=12', 'desktop');">在途项目变更</li>
						        <li  id="MEMU_FUNC17018" class="level33" onclick="actionPage('/projectWebApp/projectManage.do?action=updateInstoreProjectIndex', 'desktop');">入库项目变更</li>  
						        <li  id="MEMU_FUNC17018" class="level32" onclick="actionPage('/projectWebApp/projectManage.do?action=updateInstoreProjectIndex', 'desktop');">入库项目变更</li> 
						   </ul>                          
					</li>					
				</ul>				
			</li>
            
			<li class="level1">
			    <div class="level1Style" id="MEMU_910" onclick="menuClick(this);">
					<img class=Icon src="images/main/menuicon.gif">出纳帐管理
				</div>				
				<ul class="MenuLevel2" id="MEMU_910d" style="display:none">				    
				    <li class="level2">							
						   <div class="level2Style" id="MEMU_FUNC91001" onclick="subMenuClick(this);">
							  <img id="MEMU_FUNC91001_img" src="images/main/menu_arrow_close.gif">系统设置
						   </div>
						   <ul class="MenuLevel2" id="MEMU_FUNC91001d" style="display:none"> 
						         <li  id="MEMU_FUNC91020" class="level3Head" onclick="actionPage('/financeWebApp/cashInitBalance.do?action=cashInitBalanceIndex', 'desktop');">单位余额初始</li> 
						         <li  id="MEMU_FUNC91021" class="level32" onclick="actionPage('/financeWebApp/financeInitBalance.do?action=financeInitBalanceIndex', 'desktop');">财政余额初始</li> 
                           </ul> 
					</li>
				    <li class="level2">
						   <div class="level2Style" id="MEMU_FUNC91003" onclick="subMenuClick(this);">
							  <img id="MEMU_FUNC91003_img" src="images/main/menu_arrow_close.gif">单位日记帐录入
						   </div>
						   <ul class="MenuLevel2" id="MEMU_FUNC91003d" style="display:none"> 
						            <li  id="MEMU_FUNC91026" class="level3Head" onclick="actionPage('/financeWebApp/cashAccount.do?action=cashAccountIndex&dayType=0', 'desktop');">单位现金日记帐录入</li> 
						            <li  id="MEMU_FUNC91028" class="level33" onclick="actionPage('/financeWebApp/cashAccount.do?action=cashAccountIndex&dayType=1', 'desktop');">单位银行日记帐录入</li> 
                                    <li  id="MEMU_FUNC91030" class="level32" onclick="actionPage('/financeWebApp/cashAccount.do?action=cashAccountIndex&dayType=2', 'desktop');">单位集中支付录入</li> 
                           </ul> 
					</li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>
