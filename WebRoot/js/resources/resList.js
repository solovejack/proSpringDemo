
function btnQuery() {
	window.queryForm.submit();
//	var resIdQry = $("#resIdQry").val();
//	if(resIdQry){
//		window.queryForm.submit();
//	}else{
//		alert("请输入查询条件！");
//	}	
	return;
}

function btnCreate(){
//	window.location = "/proSpringDemo/resources.do?action=save";
	art.dialog.open('resources.do?action=qryResForm&flag=c', {
		id : 'resInfo',
		width : 400,
		height : 200,
		title : '新增权限'
	});
}

function btnEdit(resId){
	var url = "resources.do?action=qryResForm&flag=u&resId="+resId;
	art.dialog.open(url, {
		id : 'resInfo',
		width : 400,
		height : 200,
		title : '编辑权限'
	});
}

function btnDel(resId){	
	frmres.action="resources.do?action=delRes";
	$("#resId").val(resId);
	frmres.submit();
}

function resSave(){
	var flag = $("#flag").val();
	$.ajax({
		type : "POST",
		data : $('#resForm').serialize(),
		dataType : "json",
		url : "/proSpringDemo/resources.do?action=saveRes&flag="+flag,
		success : function(data, status) {
//			var result = eval("(" + data + ")");
			if (data.result == "succ") {			
				var win = art.dialog.open.origin;
				art.dialog.close();
				win.location.reload();
			} else {
				alert("加载失败");
			}
		},
		error : function(data) {
			art.dialog({
				content : '保存失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});
}

