<%@page import="learn.util.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Goods List Page</title>
<style>
img {
	width: 250px;
	height: 250px;
	display: flow;
}
</style>
</head>
<body>
	<h1>Goods List : <a href ="/WebWay/ClearServlet"> Clear </a></h1>
	<a href="/WebWay/HistoryServlet?id=01"> <img
		src="../resourse/HistoryImage/01.jpg">
	</a>
	<a href="/WebWay/HistoryServlet?id=02"> <img
		src="../resourse/HistoryImage/02.jpg">
	</a>
	<a href="/WebWay/HistoryServlet?id=03"> <img
		src="../resourse/HistoryImage/03.jpg">
	</a>
	<a href="/WebWay/HistoryServlet?id=04"> <img
		src="../resourse/HistoryImage/04.jpg">
	</a>
	<br>
	<br>

	<hr>
	<h1>Visited History :</h1>
<!-- 	<div><a > clear </a></div> -->
	<br >
	<%
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtils.findCookieByName(cookies, "history");
		if (cookie != null) {
			String[] str = cookie.getValue().split("#");
			for (int i = 0; i < str.length; i++) {
	%>
	<img src="../resourse/HistoryImage/<%=str[i]%>.jpg">

	<%
		}
		}else{
			%>
			<h2>Sorry, You didn't visited any goods!</h2> 
			<%
			
		}
	%>
	<%-- <c:forEach >
	
	</c:forEach> --%>


</body>
</html>