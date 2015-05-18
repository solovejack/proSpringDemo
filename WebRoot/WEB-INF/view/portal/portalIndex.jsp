<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" href="images/logo/logo16.ico" type="image/x-icon" />
<link rel="shortcut icon" href="images/logo/logo32.ico" type="image/x-icon" />
<link rel="bookmark" href="images/logo/logo16.ico" type="image/x-icon" />
<title>ERP</title>
</head>
<frameset rows="100,*" framespacing=0 border=0 frameborder=0>
  <frame noresize name="portalTop" scrolling="no" src="portal.do?action=portalTop&userId=${userId}"></frame>
  <frameset COLS="180, *" ID=resize>
    <frame noresize name="portalLeft" scrolling="yes" src="portal.do?action=portalLeft"></frame>
    <frame name="portalRight" scrolling="auto" src="portal.do?action=portalRight"></frame>
  </frameset> 
</frameset>
</html>