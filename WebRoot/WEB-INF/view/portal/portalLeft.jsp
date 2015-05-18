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
					<img class=Icon src="images/main/menuicon.gif">基础信息
				</div>				
				<ul class="MenuLevel2" id="MEMU_170d" style="display:none">				    					
				    <li class="level2">
                          <div class="level2Style" id="MEMU_17003" onclick="actionPage('/proSpringDemo/users.do?action=index','desktop');">
							 <img src="images/main/menu_arrow_single.gif">员工信息档案
						  </div> 
					</li>					
				    <li class="level2">	
                          <div class="level2Style" id="MEMU_17005" onclick="actionPage('/proSpringDemo/gys.do?action=index','desktop');">
							 <img src="images/main/menu_arrow_single.gif">客户信息管理
						  </div>  						 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_17007" onclick="actionPage('/proSpringDemo/ck.do?action=index','desktop');">
							 <img src="images/main/menu_arrow_single.gif">仓库信息管理
						  </div> 
					</li>													
				    <li class="level2">
                          <div class="level2Style" id="MEMU_17013" onclick="actionPage('/proSpringDemo/hw.do?action=index','desktop');">
							 <img src="images/main/menu_arrow_single.gif">货位信息档案
						  </div>    
					</li>					
				</ul>				
			</li>
            
            <li class="level1">
			    <div class="level1Style" id="MEMU_002" onclick="menuClick(this);">
					<img class=Icon src="images/main/menuicon.gif">系统管理
				</div>				
				<ul class="MenuLevel2" id="MEMU_002d" style="display:none">				    								
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00205" onclick="actionPage('/proSpringDemo/resources.do?action=index','desktop');">
							 <img src="images/main/menu_arrow_single.gif">权限管理
						  </div>  						 
					</li>				
					<li class="level2">				        
                          <div class="level2Style" id="MEMU_00203" onclick="actionPage('/proSpringDemo/userRole.do?action=index','desktop');">
							 <img src="images/main/menu_arrow_single.gif">用户角色管理
						  </div> 
					</li>	
					<li class="level2">
                          <div class="level2Style" id="MEMU_00203" onclick="actionPage('/proSpringDemo/roleRes.do?action=index','desktop');">
							 <img src="images/main/menu_arrow_single.gif">角色权限管理
						  </div>
					</li>
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00207" onclick="actionPage('/proSpringDemo/personSet.do?action=index','desktop');">
							 <img src="images/main/menu_arrow_single.gif">个人偏好设置
						  </div> 
					</li>
				</ul>				
			</li>
	
			<li class="level1">
			    <div class="level1Style" id="MEMU_003" onclick="menuClick(this);">
					<img class=Icon src="images/main/menuicon.gif">OA管理
				</div>				
				<ul class="MenuLevel2" id="MEMU_003d" style="display:none">				    
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00301" onclick="actionPage('/proSpringDemo/oaManage.do?action=mailInit','desktop');">
							 <img src="images/main/menu_arrow_single.gif">发件箱
						  </div>  
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00303" onclick="actionPage('/proSpringDemo/oaManage.do?action=mailReceiveList','desktop');">
							 <img src="images/main/menu_arrow_single.gif">收件箱
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00305" onclick="actionPage('/proSpringDemo/oaManage.do?action=mailSendList','desktop');">
							 <img src="images/main/menu_arrow_single.gif">已发件
						  </div>  						 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00307" onclick="actionPage('/proSpringDemo/oaManage.do?action=mailDraftList','desktop');">
							 <img src="images/main/menu_arrow_single.gif">草稿箱
						  </div> 
					</li>											
				</ul>				
			</li>
	
			<li class="level1">
			    <div class="level1Style" id="MEMU_004" onclick="menuClick(this);">
					<img class=Icon src="images/main/menuicon.gif">人事管理
				</div>				
				<ul class="MenuLevel2" id="MEMU_004d" style="display:none">				    
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00401" onclick="actionPage('/proSpringDemo/user.do?action=index','desktop');">
							 <img src="images/main/menu_arrow_single.gif">员工管理
						  </div>  
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00403" onclick="actionPage('/projectWebApp/projectSort.do?action=sortUnitIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">员工调动
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00405" onclick="actionPage('/projectWebApp/projectCheck.do?action=projectCheckIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">入职管理
						  </div>  						 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00407" onclick="actionPage('/projectWebApp/projectSort.do?action=sortFinalIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">培训管理
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00409" onclick="actionPage('/projectWebApp/projectQuery.do?action=findUnitSubmitProjectList','desktop');">
							 <img src="images/main/menu_arrow_single.gif">合同管理
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00411" onclick="actionPage('/projectWebApp/projectBudget.do?action=projectBudgetIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">评价管理
						  </div>  
					</li>										
				</ul>				
			</li>
	
			<li class="level1">
			    <div class="level1Style" id="MEMU_005" onclick="menuClick(this);">
					<img class=Icon src="images/main/menuicon.gif">仓储管理
				</div>				
				<ul class="MenuLevel2" id="MEMU_005d" style="display:none">				    
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00501" onclick="actionPage('/proSpringDemo/purchaseContract.do?action=contractIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">采购合同
						  </div>  
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00503" onclick="actionPage('/projectWebApp/projectSort.do?action=sortUnitIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">到货验收
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00505" onclick="actionPage('/projectWebApp/projectCheck.do?action=projectCheckIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">入库
						  </div>  						 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00507" onclick="actionPage('/projectWebApp/projectSort.do?action=sortFinalIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">出库申请
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00509" onclick="actionPage('/projectWebApp/projectQuery.do?action=findUnitSubmitProjectList','desktop');">
							 <img src="images/main/menu_arrow_single.gif">出库
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00511" onclick="actionPage('/projectWebApp/projectBudget.do?action=projectBudgetIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">盘点
						  </div>  
					</li>									
				</ul>				
			</li>
	
			<li class="level1">
			    <div class="level1Style" id="MEMU_006" onclick="menuClick(this);">
					<img class=Icon src="images/main/menuicon.gif">统计报表
				</div>				
				<ul class="MenuLevel2" id="MEMU_006d" style="display:none">				    
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00601" onclick="actionPage('/proSpringDemo/user.do?action=index','desktop');">
							 <img src="images/main/menu_arrow_single.gif">员工信息一览
						  </div>  
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00603" onclick="actionPage('/projectWebApp/projectSort.do?action=sortUnitIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">员工岗位变动
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00605" onclick="actionPage('/projectWebApp/projectCheck.do?action=projectCheckIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">出差审批一览
						  </div>  						 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00607" onclick="actionPage('/projectWebApp/projectSort.do?action=sortFinalIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">劳动合同明细
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00609" onclick="actionPage('/projectWebApp/projectQuery.do?action=findUnitSubmitProjectList','desktop');">
							 <img src="images/main/menu_arrow_single.gif">物资入库明细
						  </div> 
					</li>					
				    <li class="level2">				        
                          <div class="level2Style" id="MEMU_00611" onclick="actionPage('/projectWebApp/projectBudget.do?action=projectBudgetIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">物资出库明细
						  </div>  
					</li>		
					<li class="level2">				        
                          <div class="level2Style" id="MEMU_00611" onclick="actionPage('/projectWebApp/projectBudget.do?action=projectBudgetIndex','desktop');">
							 <img src="images/main/menu_arrow_single.gif">收发存报系统
						  </div>  
					</li>								
				</ul>				
			</li>
		</ul>
	</div>
</body>
</html>
