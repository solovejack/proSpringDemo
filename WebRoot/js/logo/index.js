//��½�?����֤
function logoValidate(){
	var usrName=document.frmLogo.usrName.value;
	var usrPwd=document.frmLogo.usrPwd.value;
	if(usrName==""){
		alert("请输入用户名");
		document.frmLogo.usrName.focus();
		return false;
	}
	if(usrPwd==""){
		alert("请输入用户密码");
		document.frmLogo.usrPwd.focus();
		return false;
	}
	return true;
}