
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student Information</title>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<h1>Edit Student Information</h1>
		<form method="post" class="form-group" action="/WebWay/UpdateStudentServlet">
			<input type="hidden" name="sid" value="${stu.sid}">
			<!-- 添加用户编号 -->
			<table class="table table-bordered table-hover table-striped" border="1">
				<tr>
					<td>Name:</td>
					<td><input type="text" class="form-control" name="sname" value="${stu.sname}"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="radio" class="radio radio-inline" name="gender" value="male" s <c:if test="${stu.gender== 'male'}"> checked </c:if>> male <input type="radio"
							class="radio radio-inline" name="gender" value="female" <c:if test="${stu.gender=='female'}">checked</c:if>>female</td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><input type="text" name="age" class="form-control" value="${stu.age} "></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" class="form-control" name="address" value="${stu.address }"></td>
				</tr>

				<tr>
					<td>TelPhone:</td>
					<td><input type="text" name="tel" class="form-control" value="${stu.tel}"></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><input type="text" name="birthday" class="form-control" value="${stu.birthday }"></td>
				</tr>
				<tr>
					<td>Hobby:</td>


					<td><input type="checkbox" name="hobby" value="reading" class="checkbox checkbox-inline" <c:if test="${fn:contains(stu.hobby,'reading')}">checked </c:if>>reading <input
							type="checkbox" name="hobby" value="sports" class="checkbox checkbox-inline" <c:if test="${fn:contains(stu.hobby,'sports')}">checked </c:if>>sports <input type="checkbox" name="hobby"
							value="movies" class="checkbox checkbox-inline" <c:if test="${fn:contains(stu.hobby,'movies')}">checked </c:if>>movies <input type="checkbox" name="hobby" value="hiking"
							class="checkbox checkbox-inline" <c:if test="${fn:contains(stu.hobby,'hiking')}">checked </c:if>>hiking <input type="checkbox" name="hobby" value="coding"
							class="checkbox checkbox-inline" <c:if test="${fn:contains(stu.hobby,'coding')}">checked </c:if>>coding <input type="checkbox" name="hobby" value="basketball"
							class="checkbox checkbox-inline" <c:if test="${fn:contains(stu.hobby,'basketball')}">checked </c:if>>basketball</td>
				</tr>
				<tr>
					<td>Information:</td>
					<td><textarea class="form-control" name="info" rows="3">${stu.info}</textarea></td>
				</tr>
				<tr>
					<td colspan=2><input type="submit" class="btn btn-info center-block" value="Update"></td>
				</tr>
			</table>
		</form>
		<a href="index.html">
			<button class="btn btn-info center-block ">Go Home</button>
		</a>
	</div>
</body>
</html>