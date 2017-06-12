<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="resource/css/style.css" />
</head>
<body>

<div class="main">
	<div class="optitle clearfix">
		<div class="title">账单管理&gt;&gt;添加数据</div>
	</div>
	<form action="MarketServlet?action=add" method="post">
		<div class="content">
			<table class="box">
			    <tr>
				    <td class="field">商品名称：</td>
					<td><input type="text" name="goodName" class="text" /></td>
				</tr>
				<tr>
				    <td class="field">商品数量：</td>
					<td><input type="text" name="goodSum" class="text" /></td>
				</tr>
				<tr>
					<td class="field">账单编号：</td>
					<td><input type="text" name="billNum" class="text" /></td>
				</tr>
				<tr>
					<td class="field">供应商：</td>
					<td><input type="text" name="suppliers" class="text" /></td>
				</tr>
				<tr>
					<td class="field">交易金额：</td>
					<td><input type="text" name="money" class="text" /></td>
				</tr>
				<tr>
					<td class="field">商品描述：</td>
					<td><textarea name="discription"></textarea></td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>
					<td><select name="isPay">
						<option value="1">是</option>
						<option value="0">否</option>
					</select></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="确认" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
		</form>
</div>

</body>
</html>
