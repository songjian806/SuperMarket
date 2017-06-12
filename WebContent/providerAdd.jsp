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
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post" action="SupplierServlet?action=add"
			onsubmit="return checkit();">
			<div class="content">
				<font color="red"></font> <input name="flag" value="doAdd"
					type="hidden">
				<table class="box">

					<tbody>
						<tr>
							<td class="field">供应商编号：</td>
							<td><input name="spId" id="textfield" class="text"
								type="text"> <font color="red">*</font></td>
						</tr>
						<tr>
							<td class="field">供应商名称：</td>
							<td><input name="spName" id="textfield2" value=""
								class="text" type="text"> <font color="red">*</font></td>

						</tr>
						<tr>
							<td class="field">供应商描述：</td>
							<td><textarea name="spDescription" id="textarea" cols="45"
									rows="5"></textarea></td>
						</tr>
						<tr>
							<td class="field">供应商联系：</td>

							<td><input name="spContacts" id="textfield2" value=""
								class="text" type="text"></td>
						</tr>
						<tr>
							<td class="field">供应商电话：</td>
							<td><input name="spPhone" id="textfield2" value=""
								class="text" type="text"></td>
						</tr>
						
						<tr>
							<td class="field">供应商地址：</td>
							<td><input name="spAddress" id="textfield2" value=""
								class="text" type="text"></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="buttons">
				<input name="button" id="button" value="提交" class="input-button"
					type="submit"> <input name="button" id="button"
					onclick="window.location='provider.do';" value="返回"
					class="input-button" type="button">
			</div>
		</form>
	</div>
</body>
</html>
