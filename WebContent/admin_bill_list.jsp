<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="resource/css/style.css" />
<script type="text/javascript" src="resource/js/jquery.js"></script>
<script type="text/javascript" src="resource/js/bill.js"></script>
</head>
<body>

<div class="menu">
	<form  action="" method="post">
		商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="payStatus">
			<option value="">请选择</option>
			<option value="1">已付款</option>
			<option value="0">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" name="submit" id="search" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
<form>
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" onclick="location.href='modify.jsp'" class="input-button" /></em>
		<em><input type="button" name="button" value="删除数据" id="del" class="input-button"/></em>
		<em><input type="button" name="button" value="修改数据" id="modify" class="input-button"/></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list" id="mainDiv">
			<tr>
				<td>全选<input type="checkbox" name="" id="check" ></td>
				<td>账单编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>交易金额</td>
				<td>是否付款</td>
				<td>供应商名称</td>
				<td>商品描述</td>
				<td>账单时间</td>		
			</tr>					
		</table>
		</form>
	</div>
</div>
</body>
</html>
