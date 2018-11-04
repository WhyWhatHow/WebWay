<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="learn.util.CookieUtils"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Goods Detail's Page</h1>
	<br>
	<%
	
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtils.findCookieByName(cookies, "history");
		if (cookie != null) {
			String[] str = cookie.getValue().split("#");
		 	System.out.println(str.toString());
	%>
	<img src="../resourse/HistoryImage/<%=str[str.length-1]%>.jpg">
	<%
		}
 	%>
	<a href = "GoodsList.jsp"  style="width:2em">GoBack</a> 
	 
</body>
</html>