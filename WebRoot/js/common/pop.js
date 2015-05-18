/**
 * oa邮件查询pop
 */
function popQryMail(postId){
	if(!postId){
		alert("没有主键！");
		return;
	}
    //弹出窗口
	var url="oaManage.do?action=mailDetail&postId="+postId;
	art.dialog.open(url, {
		id : 'popMailQuery',
		width : 1000,
		height : 500,
		title : '邮件内容'
	});
}