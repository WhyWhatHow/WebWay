<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stundent Information Managerment System</title>
</head>
<body>
	<h1> welcome to login in stuManager System!</h1>
	<form action="/WebWay/LoginServlet" method = "post">	
		账号: <input type="text" name="username" /><br>
		密码: <input type="password" name="password" /><br>
		<input type="submit" value="登录"name = "submit">
	</form>
</body>
</html>