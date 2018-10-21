<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试请求转发的页面</title>
</head>
<body>
	<h1>这是请求转发的页面，</h1>
	<h1 style= "color: red;">请注意查看IP</h1>
	<h1> name :
	 <%

	 	String name = request.getParameter("name"); // c-s阶段
		System.out.println(name);	 	
	%></h1>
	
</body>
</html>