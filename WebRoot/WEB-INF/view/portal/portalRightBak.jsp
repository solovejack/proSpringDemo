<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ERP</title>
<link type="text/css" rel="stylesheet"	href="css/main/desktop.css" />
<link type="text/css" rel="stylesheet"	href="css/global/base.css" />
<script src="js/global/jquery/bgrow.js"></script>
<script src="js/global/jquery/jquery.min.js"></script>
<script src="js/global/dialog/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="js/global/dialog/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script language="javascript" src="js/main/desktop.js"></script>
</head>
<body onload="init(1,7)">
  <div style="width:100%; float:left;">  
    
     
     <div id="divblock">
       <div id="Block">
           <div id="BlockHead">
                <table border="0" cellspacing="0" cellpadding="0" height="100%" width="100%">
                    <tr valign="middle">
                          <td width="25">
                            <img border="0" width="15" height="15" src="images/main/fun.gif" />
                           </td>
                          <td>我的事务</td>
                          <td width="14">
                              <img width="11" height="11" border="0" onclick="initPortalMyTask(1,7)" title="刷新" src="images/main/refresh.gif" />
                          </td>
                          <td width="14">
                              <img width="11" height="11" border="0" onclick="morePortalMyTask()" title="更多" src="images/main/more.gif" />
                          </td>
                          <td width="5"></td>
                     </tr>
                </table>
            </div>
            <div class="BlockMemo" id="divMyTaskLoad">
               <img border="0" src="images/main/loading.gif" />
            </div>
            <div id="divMyTask" class="divBGDetail" style="display:none"></div>
        </div>   
     </div>
     
   
     
     <div id="divblock">
       <div id="Block">
           <div id="BlockHead">
                <table border="0" cellspacing="0" cellpadding="0" height="100%" width="100%">
                    <tr valign="middle">
                          <td width="25">
                            <img border="0" width="15" height="15" src="images/main/fun.gif" />
                           </td>
                          <td>他人事务</td>
                          <td width="14">
                              <img width="11" height="11" border="0"  onclick="initPortalOtherTask(1,7)" title="刷新" src="images/main/refresh.gif" />
                          </td>
                          <td width="14">
                              <img width="11" height="11" border="0"  onclick="morePortalOtherTask(1,12)" title="更多" src="images/main/more.gif" />
                          </td>
                          <td width="5"></td>
                     </tr>
                </table>
            </div>
           <div class="BlockMemo" id="divOtherTaskLoad">
               <img border="0" src="images/main/loading.gif" />
            </div>
            <div id="divOtherTask" class="divBGDetail" style="display:none"></div>
        </div>   
     </div>    
    
     <div id="divblock" >
       <div id="Block">
           <div id="BlockHead">
                <table border="0" cellspacing="0" cellpadding="0" height="100%" width="100%">
                    <tr valign="middle">
                          <td width="25">
                            <img border="0" width="15" height="15" src="images/main/fun.gif" />
                           </td>
                          <td>办结事务</td>
                          <td width="14">
                              <img width="11" height="11" border="0" onclick="initPortalFinishedTask(1,7)" title="刷新" src="images/main/refresh.gif" />
                          </td>
                          <td width="14">
                              <img width="11" height="11" border="0" onclick="morePortalFinishedTask(1,12)" title="更多" src="images/main/more.gif" />
                          </td>
                          <td width="5"></td>
                     </tr>
                </table>
            </div>
            <div class="BlockMemo" id="divFinishedTaskLoad">
               <img border="0" src="images/main/loading.gif" />
            </div>
            <div id="divFinishedTask" class="divBGDetail" style="display:none"></div>
        </div>   
     </div>
  </div>
</body>
</html>