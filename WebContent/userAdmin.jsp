<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="resource/css/style.css">
<script type="text/javascript" src="resource/js/jquery.js"></script>
<script type="text/javascript" charset="utf-8" src="resource/js/user.js"></script>
</head>

<body>
<div class="menu">
<table>
<tbody><tr><td><form method="post" action="UserServlet?action=search">
<input name="flag" value="search" class="input-text" type="hidden">
用户名称：<input name="userName" id="searchname" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; <input value="查 询" id="search" type="button">
</form></td></tr>
</tbody></table>
</div>
<div class="main">

<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='userAdd.jsp'" type="button"></em>
<em><input value="删除数据" class="input-button" id="del" type="button"></em>
<em><input value="修改数据" class="input-button" id="modify" type="button"></em>

		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tbody id = "mainDiv"><tr>
    <td width="50">全选<input type="checkbox" name="" id="check" ></td>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>
    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="100"><div class="STYLE1" align="center">权限 </div></td>
  </tr>
</tbody></table>
</div>
</div>
</body></html>