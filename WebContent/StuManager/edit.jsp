
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student Information</title>
</head>
<body>
	<h1>Edit Student Information</h1>
	<form method="post" action="/WebWay/UpdateStudentServlet">
		<input type="hidden" name="sid" value="${stu.sid}">
		<!-- 添加用户编号 -->
		<table border="1" width="600">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="sname" value="${stu.sname}"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male" s
					<c:if test="${stu.gender== 'male'}"> checked </c:if>> male
					<input type="radio" name="gender" value="female"
					<c:if test="${stu.gender=='female'}">checked</c:if>>female

				</td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="age" value="${stu.age} "></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" value="${stu.address }"></td>
			</tr>

			<tr>
				<td>TelPhone:</td>
				<td><input type="text" name="tel" value="${stu.tel}"></td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type="text" name="birthday" value="${stu.birthday }"></td>
			</tr>
			<tr>
				<td>Hobby:</td>


				<td><input type="checkbox" name="hobby" value="reading"
					<c:if test="${fn:contains(stu.hobby,'reading')}">checked </c:if>>reading
					<input type="checkbox" name="hobby" value="sports"
					<c:if test="${fn:contains(stu.hobby,'sports')}">checked </c:if>>sports
					<input type="checkbox" name="hobby" value="movies"
					<c:if test="${fn:contains(stu.hobby,'movies')}">checked </c:if>>movies
					<input type="checkbox" name="hobby" value="hiking"
					<c:if test="${fn:contains(stu.hobby,'hiking')}">checked </c:if>>hiking
					<input type="checkbox" name="hobby" value="coding">coding <input
					type="checkbox" name="hobby" value="basketball"
					<c:if test="${fn:contains(stu.hobby,'basketball')}">checked </c:if>>basketball
				</td>
			</tr>
			<tr>
				<td>Information:</td>
				<td><textarea name="info" rows="3" cols="80">${stu.info}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
	<a href="index.html"><button>Go Home</button></a>

</body>
</html>