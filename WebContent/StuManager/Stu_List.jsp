<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>Sid</td>
			<td>Name</td>
			<td>Gender</td>
			<td>Age</td>
			<td>Address</td>
			<td>Tel</td>
			<td>Option</td>

		</tr>
		<c:forEach var="stu" items="${list }">
			<tr>
				<td>${stu.sid }</td>
				<td>${stu.name }</td>
				<td>${stu.gender}</td>
				<td>${stu.age }</td>
				<td>${stu.address }</td>
				<td>${stu.tel }</td>
				<td><a href ="#">Update</a> <a href ="#">delete</a></td>

			</tr>
		</c:forEach>

	</table>

</body>
</html>