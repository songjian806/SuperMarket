<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
      function jumpurl(){
	   location='MarketServlet?action=imassage';
      }
		setTimeout('jumpurl()', 3000);	
</script>
</head>
<body>

	<h1>${tips}</h1>
	<a href="MarketServlet?action=imassage">3秒后系统会自动跳转主界面，也可点击此处直接跳转</a>
</body>
</html>