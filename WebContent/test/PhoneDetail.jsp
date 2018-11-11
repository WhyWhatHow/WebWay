<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pnone Detail's Page </title>
</head>
<body>
	
	 <h1>Phone Detail's Page </h1>
	 
	 <br>
	<!-- 输出手机名称 -->	
	<%
		String name = request.getParameter("name");
		String id = request.getParameter("id");
	%>
	<h3>PhoneID: </h3>
	<h4>
		<%=id %>
	</h4>	
	
	<h3>PhoneName: </h3>
	<h4>
		<%=name %>
	</h4>	
	 <a href = "/WebWay/PhoneBuyServlet?id=<%=id %>&name=<%=name%>"> <h2> 购买</h2></a>
	 
	<br>

	<a href = "./test/PhoneList.jsp"><h3>return to Phone List's Page</h3></a>
	s
</body>
</html>