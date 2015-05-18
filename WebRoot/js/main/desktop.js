function init(curPage, pageRows){
	initPortalNews(curPage, pageRows);
	initPortalAnn(curPage, pageRows);
	initPortalNotice(curPage, pageRows);
	initPortalMyTask(curPage, pageRows);
	initPortalOtherTask(curPage, pageRows);
	initPortalFinishedTask(curPage, pageRows);
}
/**
 * 初始化系统新闻
 */
function initPortalNews(curPage, pageRows) {
	divNewsLoad.style.display="block";
	divNews.style.display="none";
	$.ajax({
		type : "POST",
		url : "/msgWebApp/news.do?action=queryNews&curPage=" + curPage
				+ "&pageRows=" + pageRows,
		dataType : "json",
		cache : true,
		success : function(result) {
			if (result.result == "succ") {
				var jsonList = result.page.pageResult;
				var blankCount = pageRows;
				var divData = "<ul>";
				$.each(jsonList, function(index) {
					var info=jsonList[index].msgContents;
					info=info.replace(/<\/?[^>]*>/g,''); //去除所有的<p>
					if(info.length>30){
						info=info.substring(0,30);
					}
					var dt=jsonList[index].msgSendDate;
					dt=dt.substring(0,10);
					divData = divData + "<li class='DetailLine'><div class='DetailLineInfo'><img src='images/main/mail.gif' width='9' height='7'/><a style='padding-left:5px;cursor:hand' onclick='viewNews("+jsonList[index].msgId+")'>"+info+"</a></div><div class='DetailLineTime' title='发布日期' style='cursor:pointer'>"+dt+"</div></li>";
					blankCount--;
				});
				for (var i = 0; i < blankCount; i++) {
					divData = divData + "<li class='DetailLine'><div>&nbsp;</div></li>";
				}				
				divData = divData + "</ul>";
				divData = divData + "<div id='BlockFoot'><div id='BlockFootMore'><img border=0 width=9 height=8 src='images/main/more2.gif'/><a style='cursor:hand' onclick='morePortalNews(1,12)'>更多...</a></div></div>";
				divNews.innerHTML = divData;
				
				divNewsLoad.style.display="none";
				divNews.style.display="block";
			} 
		},
		error : function(result) {
			divNewsLoad.style.display="block";
			divNews.style.display="none";
		}
	});
}

function trim(s){        
	var rtn=[];        
	var reg=/(<p>.*?<\/p>)/i;         
	while(reg.test(s)){            
		rtn[rtn.length]=RegExp.$1;             
		s=s.substring(RegExp.lastIndex,s.length);         
	}         
	return rtn.join("");    
} 
function morePortalNews(curPage, pageRows) {
	var url="/msgWebApp/news.do?action=list&curPage="+curPage+"&pageRows="+pageRows;
	window.parent.portalRight.location=url;
}
function viewNews(msgId){
	art.dialog.open("/msgWebApp/news.do?action=view&msgId="+msgId,{width :750,height:338,title:"查看系统新闻"},false);
}

/**
 * 初始化系统公告
 */
function initPortalAnn(curPage, pageRows) {
	divAnnLoad.style.display="block";
	divAnn.style.display="none";
	$.ajax({
		type : "POST",
		url : "/msgWebApp/announcement.do?action=queryAnn&msgStatus=-1&curPage=" + curPage
				+ "&pageRows=" + pageRows,
		dataType : "json",
		cache : true,
		success : function(result) {
			if (result.result == "succ") {
				var jsonList = result.page.pageResult;
				var blankCount = pageRows;
				var divData = "<ul>";
				$.each(jsonList, function(index) {
					var info=jsonList[index].msgSubject;
					info=info.replace(/<\/?[^>]*>/g,''); //去除所有的<p>
					if(info.length>30){
						info=info.substring(0,30);
					}
					divData = divData + "<li class='DetailLine'><div class='DetailLineInfo'><img src='images/main/mail.gif' width='9' height='7'/><a style='padding-left:5px;cursor:hand' onclick='viewAnn("+jsonList[index].msgId+")'>"+info+"</a></div><div class='DetailLineTime' title='发布日期' style='cursor:pointer'>"+jsonList[index].msgPublishDate+"</div></li>";
					blankCount--;
				});
				for (var i = 0; i < blankCount; i++) {
					divData = divData + "<li class='DetailLine'><div>&nbsp;</div></li>";
				}				
				divData = divData + "</ul>";
				divData = divData + "<div id='BlockFoot'><div id='BlockFootMore'><img border=0 width=9 height=8 src='images/main/more2.gif'/><a  style='cursor:hand' onclick='morePortalAnn(1,12)'>更多...</a></div></div>";
				divAnn.innerHTML = divData;
				
				divAnnLoad.style.display="none";
				divAnn.style.display="block";
			} 
		},
		error : function(result) {
			divAnnLoad.style.display="block";
			divAnn.style.display="none";
		}
	});
}
function morePortalAnn(curPage, pageRows) {
	var url="/msgWebApp/announcement.do?action=list&curPage="+curPage+"&pageRows="+pageRows;
	window.parent.portalRight.location=url;
}
function viewAnn(msgId){
	art.dialog.open("/msgWebApp/announcement.do?action=view&msgId="+msgId,{width :750,height:445,title:"查看系统公告"},false);
}

/**
 * 初始化系统通知
 */
function initPortalNotice(curPage, pageRows) {
	divNoticeLoad.style.display="block";
	divNotice.style.display="none";
	$.ajax({
		type : "POST",
		url : "/msgWebApp/notice.do?action=queryNotice&curPage=" + curPage
				+ "&pageRows=" + pageRows,
		dataType : "json",
		cache : true,
		success : function(result) {
			if (result.result == "succ") {
				var jsonList = result.page.pageResult;
				var blankCount = pageRows;
				var divData = "<ul>";
				$.each(jsonList, function(index) {
					var info=jsonList[index].msgContent;
					info=info.replace(/<\/?[^>]*>/g,''); //去除所有的<p>
					if(info.length>30){
						info=info.substring(0,30);
					}
					var dt=jsonList[index].msgSendDate;
					dt=dt.substring(0,10);
					var colorA="";
					var title="平急";
					var msgPrior=jsonList[index].msgPrior;//等级程度
					if(msgPrior>0){
						colorA='msgpriorColor'+msgPrior;
						if(msgPrior==1){
							title='加急'
						}else if(msgPrior==2){
							title='特急 '
						}else if(msgPrior==3){
							title='特提'
						}
					}
					divData = divData + "<li class='DetailLine'><div class='DetailLineInfo'><img src='images/main/mail.gif' width='9' height='7'/><a style='padding-left:5px;cursor:hand' onclick='viewNotice("+jsonList[index].msgId+")' class='"+colorA+"' title='"+title+"' style='cursor:pointer'>"+info+"</a></div><div class='DetailLineTime' title='发布日期' style='cursor:pointer'>"+dt+"</div></li>";
					blankCount--;
				});
				for (var i = 0; i < blankCount; i++) {
					divData = divData + "<li class='DetailLine'><div>&nbsp;</div></li>";
				}				
				divData = divData + "</ul>";
				divData = divData + "<div id='BlockFoot'><div id='BlockFootMore'><img border=0 width=9 height=8 src='images/main/more2.gif'/><a  style='cursor:hand' onclick='morePortalNotice(1,12)'>更多...</a></div></div>";
				divNotice.innerHTML = divData;
				
				divNoticeLoad.style.display="none";
				divNotice.style.display="block";
			} 
		},
		error : function(result) {
			divNoticeLoad.style.display="block";
			divNotice.style.display="none";
		}
	});
}
function morePortalNotice(curPage, pageRows) {
	var url="/msgWebApp/notice.do?action=list&curPage="+curPage+"&pageRows="+pageRows;
	window.parent.portalRight.location=url;
}
function viewNotice(msgId){
	art.dialog.open("/msgWebApp/notice.do?action=view&msgId="+msgId,{width :750,height:420,title:"查看系统通知"},false);
}


/**
 * 初始化我的任务
 */
function initPortalMyTask(curPage, pageRows) {
	divMyTaskLoad.style.display="block";
	divMyTask.style.display="none";
	$.ajax({
		type : "POST",
		url : "/workflow/workflowTask.do?action=queryMyTask&pageRows=" + pageRows,
		dataType : "json",
		cache : true,
		success : function(result) {
			if (result.result == "succ") {
				var jsonList = result.page;
				var blankCount = pageRows;
				var divData = "<ul>";
				var rowCount=0;
				$.each(jsonList, function(index) {
					if(rowCount<7){
					var unitName=jsonList[index].taskFlowUnitName;
					var flowTypeId=jsonList[index].taskFlowTypeId;
					var flowType=jsonList[index].taskFlowTypeName;
					var createDate=jsonList[index].taskCreateDate;
					var taskExecuteId=jsonList[index].taskExecuteId;			
					divData = divData +"<li class='DetailLine'><div class='DetailLineInfo'><img src='images/main/mail.gif' width='9' height='7'/><a style='padding-left:5px;cursor:hand'";
					//处理项目管理的任务
					if(flowTypeId=="FLOW_TYPE_FLOW_TYPE3"){
						divData = divData +" onclick='funViewPrjectStep()'";
					}else{
						divData = divData +" onclick='funViewOtherStep()'";
					}
					divData = divData + ">单位&nbsp;<font color='red'>"+unitName+"</font>&nbsp;&nbsp;编号为&nbsp;<font color='red'>"+taskExecuteId+"</font>&nbsp;的"+flowType+"&nbsp;等待您的办理</a></div><div class='DetailLineTime'>"+createDate+"</div></li>";
					blankCount--;
					rowCount++;
					}
				});
				for (var i = 0; i < blankCount; i++) {
					divData = divData + "<li class='DetailLine'><div>&nbsp;</div></li>";
				}				
				divData = divData + "</ul>";
				divData = divData + "<div id='BlockFoot'><div id='BlockFootMore'><img border=0 width=9 height=8 src='images/main/more2.gif'/><a  style='cursor:hand' onclick='morePortalMyTask()'>更多...</a></div></div>";
				divMyTask.innerHTML = divData;
				
				divMyTaskLoad.style.display="none";
				divMyTask.style.display="block";
			} 
		},
		error : function(result) {
			divMyTaskLoad.style.display="block";
			divMyTask.style.display="none";
		}
	});
}
function morePortalMyTask() {
	var url="/workflow/workflowTask.do?action=myTasklist";
	window.parent.portalRight.location=url;
}
/**
 * 初始化他人的任务
 */
function initPortalOtherTask(curPage, pageRows) {
	divOtherTaskLoad.style.display="block";
	divOtherTask.style.display="none";
	$.ajax({
		type : "POST",
		url : "/workflow/workflowTask.do?action=queryOtherTask&pageRows=" + pageRows,
		dataType : "json",
		cache : true,
		success : function(result) {
			if (result.result == "succ") {
				var jsonList = result.page;
				var blankCount = pageRows;
				var divData = "<ul>";
				var rowCount=0;
				$.each(jsonList, function(index) {
					if(rowCount<7){
					var unitName=jsonList[index].taskFlowUnitName;
					var flowType=jsonList[index].taskFlowTypeName;
					var taskCreateDate=jsonList[index].taskCreateDate;
					var taskExecuteId=jsonList[index].taskExecuteId;		
					var assignee=jsonList[index].assignee;	
					
					divData = divData + "<li class='DetailLine'>" +
					"<div class='DetailLineInfo'><img src='images/main/mail.gif' width='9' height='7'/><a style='padding-left:5px;cursor:hand'>单位&nbsp;<font color='red'>"+unitName+"</font>&nbsp;&nbsp;编号为&nbsp;<font color='red'>"+taskExecuteId+"</font>&nbsp;的"+flowType+"&nbsp;等待&nbsp;<font color='red'>"+assignee+"</font>&nbsp;办理</a></div>" +
					"<div class='DetailLineTime'>"+taskCreateDate+"</div></li>";
					blankCount--;
					rowCount++;
					}
				});
				for (var i = 0; i < blankCount; i++) {
					divData = divData + "<li class='DetailLine'><div>&nbsp;</div></li>";
				}				
				divData = divData + "</ul>";
				divData = divData + "<div id='BlockFoot'><div id='BlockFootMore'><img border=0 width=9 height=8 src='images/main/more2.gif'/><a  style='cursor:hand' onclick='morePortalOtherTask()'>更多...</a></div></div>";
				divOtherTask.innerHTML = divData;
				
				divOtherTaskLoad.style.display="none";
				divOtherTask.style.display="block";
			} 
		},
		error : function(result) {
			divOtherTaskLoad.style.display="block";
			divOtherTask.style.display="none";
		}
	});
}
function morePortalOtherTask() {
	var url="/workflow/workflowTask.do?action=otherTasklist";
	window.parent.portalRight.location=url;
}

/**
 * 初始化办结的任务
 */
function initPortalFinishedTask(curPage, pageRows) {
	divFinishedTaskLoad.style.display="block";
	divFinishedTask.style.display="none";
	$.ajax({
		type : "POST",
		url : "/workflow/workflowTask.do?action=queryFinishedTask&pageRows=" + pageRows,
		dataType : "json",
		cache : true,
		success : function(result) {
			if (result.result == "succ") {
				var jsonList = result.page;
				var blankCount = pageRows;
				var rowCount=0;
				var divData = "<ul>";
				$.each(jsonList, function(index) {
					if(rowCount<7){
					var unitName=jsonList[index].taskFlowUnitName;
					var flowType=jsonList[index].taskFlowTypeName;
					var endDate=jsonList[index].endDate;
					var duration=jsonList[index].duration;			
					var taskExecuteId=jsonList[index].taskExecuteId;
					
					divData = divData + "<li class='DetailLine'>" +
					"<div class='DetailLineInfo'><img src='images/main/mail.gif' width='9' height='7'/><a style='padding-left:5px;cursor:hand'>单位<font color='red'>"+unitName+"</font>;编号为<font color='red'>"+taskExecuteId+"</font>&nbsp;的"+flowType+"&nbsp;已办结,周期&nbsp;<font color='red'>"+duration+"</font></a></div>" +
					"<div class='DetailLineTime'>"+endDate+"</div></li>";
			        blankCount--;
			        rowCount++;
					}
				});
				for (var i = 0; i < blankCount; i++) {
					divData = divData + "<li class='DetailLine'><div>&nbsp;</div></li>";
				}				
				divData = divData + "</ul>";
				divData = divData + "<div id='BlockFoot'><div id='BlockFootMore'><img border=0 width=9 height=8 src='images/main/more2.gif'/><a  style='cursor:hand' onclick='morePortalFinishedTask()'>更多...</a></div></div>";
				divFinishedTask.innerHTML = divData;
				
				divFinishedTaskLoad.style.display="none";
				divFinishedTask.style.display="block";
			} 
		},
		error : function(result) {
			divFinishedTaskLoad.style.display="block";
			divFinishedTask.style.display="none";
		}
	});
}
function morePortalFinishedTask() {
	var url="/workflow/workflowTask.do?action=finishedTasklist";
	window.parent.portalRight.location=url;
}

//流程审批之查看项目管理流程
function funViewPrjectStep(){
	var url = "/projectWebApp/projectCheck.do?action=projectCheckIndex";
	window.location.href = url;
}

function funViewOtherStep(){
	alert("正在开发.....");
}