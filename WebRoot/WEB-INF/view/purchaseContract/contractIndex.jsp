<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>采购合同</title>
<link rel="stylesheet" type="text/css" href="css/global/base.css">
<link rel="stylesheet" type="text/css" href="css/global/table.css">
<script src="js/global/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
</head>
<body>
   <div id="menuBar" style="height:30px;">
      <ul>
         <li style="float:left;padding-left:10px;"><input type="button" value="首&nbsp;&nbsp;条" style="width:80px;"/></li>
         <li style="float:left;padding-left:10px;"><input type="button" value="上一条" style="width:80px;"/></li>
         <li style="float:left;padding-left:10px;"><input type="button" value="下一条" style="width:80px;"/></li>
         <li style="float:left;padding-left:10px;"><input type="button" value="末&nbsp;&nbsp;条" style="width:80px;"/></li>
         <li style="float:left;padding-left:10px;"><input type="button" value="添&nbsp;&nbsp;加" style="width:80px;"/></li>
      </ul>
   </div>
   <fieldset style="color:#ccc;">
   <legend>主表信息</legend>
   <div id="masterTable" style="width:90%;padding-top:10px;padrding-left:10px;text-align:center;">
     <table cellpadding="0" border="0" cellspacing="0" width="100%">
       <tr>
          <td colspan="8" align="left" style="padding-left:25px;">
                         合同编号<select/>
             <input type="button" value="查询"/>            
          </td>
       </tr>
       <tr>
         <td>合同编号</td>
         <td><input value="${contract.htbm}" /></td>
         <td>合同名称</td>
         <td><input value="${contract.htmc}" /></td>
         <td>生效日期</td>
         <td><input value="${contract.sxrq}" /></td>
         <td>经办人</td>
         <td><input value="${contract.zdr}"/></td>
       </tr>
        <tr>
         <td>合同类型</td>
         <td><input value="${contract.htbm}" /></td>
         <td>合同属性</td>
         <td><input value="${contract.htbm}" /></td>
         <td>签订日期</td>
         <td><input value="${contract.qdrq}" /></td>
         <td>签订地点</td>
         <td><input value="${contract.qddd}"/></td>
       </tr>
        <tr>
         <td>买方名称</td>
         <td><input value="${contract.gysmc}"/></td>
         <td>法定代表</td>
         <td><input value="${contract.fddb}"/></td>
         <td>联系电话</td>
         <td><input value="${contract.lxr}"/></td>
         <td>地址</td>
         <td><input value="${contract.qddd}"/></td>
       </tr>
        <tr>
         <td>卖方名称</td>
         <td><input value="${contract.mfdwmc}"/></td>
         <td>法定代表</td>
         <td><input value="${contract.mffddb}"/></td>
         <td>联系电话</td>
         <td><input value="${contract.mfczhm}"/></td>
         <td>地址</td>
         <td><input value="${contract.mfdwdz}"/></td>
       </tr>
     </table>
   </div>
   </fieldset>
   <fieldset style="color:#ccc;">
   <legend>明细信息</legend>
   <div id="detailTable" style="width:99%;padding-top:10px;padrding-left:10px;text-align:center;">
     <table cellpadding="0" border="0" cellspacing="0" width="100%" class="table">
       <tr>
         <td class="tabSingleHeader" width="10%">编码</td>
         <td class="tabSingleHeader" width="10%">名称</td>
         <td class="tabSingleHeader" width="10%">计量单位</td>
         <td class="tabSingleHeader" width="10%">数量</td>
         <td class="tabSingleHeader" width="10%">价格</td>
         <td class="tabSingleHeader" width="10%">金额</td>
         <td class="tabSingleHeader" width="10%">税率</td>
         <td class="tabSingleHeader" width="10%">交货日期</td>
         <td class="tabSingleHeader" width="10%">规格型号</td>
         <td class="tabSingleHeader" width="10%">操作</td>
       </tr>
       <tbody id="tb">
        <tr height="25px" onmouseover="rowmouseover(this)"  class="tr2" onmouseout="rowmouseout(this,'tr2')">
         <td>编码</td>
         <td>名称</td>
         <td>计量单位</td>
         <td>数量</td>
         <td>价格</td>
         <td>金额</td>
         <td>税率</td>
         <td>交货日期</td>
         <td>规格型号</td>
         <td>操作</td>
       </tr>
       <tr height="25px" onmouseover="rowmouseover(this)"  class="tr1" onmouseout="rowmouseout(this,'tr1')">
         <td>编码</td>
         <td>名称</td>
         <td>计量单位</td>
         <td>数量</td>
         <td>价格</td>
         <td>金额</td>
         <td>税率</td>
         <td>交货日期</td>
         <td>规格型号</td>
         <td>操作</td>
       </tr>
       <tr height="25px" onmouseover="rowmouseover(this)"  class="tr2" onmouseout="rowmouseout(this,'tr2')">
         <td>编码</td>
         <td>名称</td>
         <td>计量单位</td>
         <td>数量</td>
         <td>价格</td>
         <td>金额</td>
         <td>税率</td>
         <td>交货日期</td>
         <td>规格型号</td>
         <td>操作</td>
       </tr>
       </tbody>
     </table>
   </div>
   </fieldset>
</body>
</html>