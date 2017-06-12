<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="resource/css/style.css">
<script type="text/javascript" src="resource/js/jquery.js"></script>
<script type="text/javascript" charset="utf-8" src="resource/js/supplier.js"></script>

</head>
<body>
<div class="menu">

<table>
<tbody><tr><td><form method="post" action="SupplierServlet?action=comqury">
<input name="flag" value="search" type="hidden">
供应商名称：<input name="providerName" class="input-text" type="text"> &nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input value="组 合 查 询" id="comqury" type="button">
</form></td></tr>
</tbody></table>
</div>
<div class="main">
<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='providerAdd.jsp'" type="button"></em>
<em><input value="修改数据" class="input-button"  id="modifyButton"  type="button"></em>
<em><input value="删除数据" class="input-button" name="del" type="button"></em>
		<div class="title">供应商管理&gt;&gt;</div>
	</div>

	<div class="content">
<table class="list" id="mainDiv">
  <tr>
    <td>全选<input type="checkbox" name="" id="check" ></td>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
    <td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
    <td width="100"><div class="STYLE1" align="center">联系人</div></td>
    <td width="100"><div class="STYLE1" align="center">电话</div></td>
    <td width="100"><div class="STYLE1" align="center">地址</div></td>
  </tr>
  
</table>
	</div>
</div>
</body></html>