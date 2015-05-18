var setting = {
	data : {
		simpleData : {
			enable : true
		}
	}
};

$(document).ready(function() {
	//----------------------------------------------------------------------
	$.ajax({
		type: "POST",
		url: "/portal/portal.do?action=adminmiddleleftTreeData",				
		dataType: "json",
		cache: true,
		success:function(result){
			if(result.result=="succ"){
				var zNodesBase=result.resultBaselist;
				var zNodesFlow=result.resultFlowlist;
				$.fn.zTree.init($("#baseTree"), setting, zNodesBase);
				$.fn.zTree.init($("#flowTree"), setting, zNodesFlow);				
			}else{
				art.dialog({
    			    content: "<span style='font-size:12px'>菜单初始化失败</span>",			   
    			    title:"错误",
    			    cancelVal: '关闭',
    			    icon: 'error'
    			});
			}			
		},
		error: function(result){
     		if(result.status==200){
     			art.dialog({
    			    content: "<span style='font-size:12px'>"+result.responseText+"</span>",			   
    			    title:"错误信息",
    			    cancelVal: '关闭',
    			    icon: 'error'
    			});
     		}else{
     			art.dialog({
    			    content: "<span style='font-size:12px'>初始化失败</span>",			   
    			    title:"错误信息",
    			    cancelVal: '关闭',
    			    icon: 'error'
    			});
     		}
		}
	});	
	//---------------------------------------------------------------------------
	
});

function showMenu(sign) {
	if (sign == "B") {
		middle_left_fun1.style.background = "#04a2fd";
		middle_left_fun2.style.background = "#cccccc";
		divtreeB.style.display = "block";
		divtreeS.style.display = "none";
	} else {
		middle_left_fun1.style.background = "#cccccc";
		middle_left_fun2.style.background = "#04a2fd";
		divtreeB.style.display = "none";
		divtreeS.style.display = "block";
	}
}
function resizeTree() {
	var h1 = document.documentElement.clientHeight;
	divtreeB.style.height = h1 - 45;
	divtreeS.style.height = h1 - 45;	
	//var ch=window.screen.availHeight - 290;
	baseTree.style.height=h1 - 84;
	flowTree.style.height=h1 - 84;
}