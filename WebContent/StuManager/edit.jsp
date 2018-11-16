<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student Information</title>
</head>
<body>
	<center>
		<h1>Edit Student Information</h1>
		<form method="post" action="UpdateServlet">
			<input type="hidden" name="sid" value="${stu.sid }">
			<!-- 添加用户编号 -->
			<table border="1" width="600">
				<tr>
					<td>Name:</td>
					<td><input type="text" name="sname" value="${stu.sname }"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>
						<!-- 如果性别是男的，  可以在男的性别 input标签里面， 出现checked ,
		如果性别是男的，  可以在女的性别 input标签里面，出现checked --> <input type="radio"
						name="gender" value="boy"
						<%-- <c:if test="${stu.gender.equal("boy")}">checked</c:if> --%>>Boy
						<input
						type="radio" name="gender" value="girl"
						<%-- <c:if test="${stu.gender.equal("girl")}">checked</c:if> --%>>Girl
					</td>
				</tr>
				<tr>
					<td>TelPhone:</td>
					<td><input type="text" name="phone" value="${stu.phone }"></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><input type="text" name="birthday"
						value="${stu.birthday }"></td>
				</tr>
				<tr>
					<td>Hobby:</td>


					<td>
						<!-- 爱好： 篮球 ， 足球 ， 看书 
		因为爱好有很多个，  里面存在包含的关系 --> <%-- 	<input type="checkbox" name="hobby" value="游泳" <c:if test="${fn:contains(stu.hobby,'游泳') }">checked</c:if>>游泳
		<input type="checkbox" name="hobby" value="篮球" <c:if test="${fn:contains(stu.hobby,'篮球') }">checked</c:if>>篮球
		<input type="checkbox" name="hobby" value="足球" <c:if test="${fn:contains(stu.hobby,'足球') }">checked</c:if>>足球
		<input type="checkbox" name="hobby" value="看书" <c:if test="${fn:contains(stu.hobby,'看书') }">checked</c:if>>看书
		<input type="checkbox" name="hobby" value="写字" <c:if test="${fn:contains(stu.hobby,'写字') }">checked</c:if>>写字
	 --%> 
	  					<input type="checkbox" name="hobby" value="reading">reading
						<input type="checkbox" name="hobby" value="sports">sports
						<input type="checkbox" name="hobby" value="movies">movies
						<input type="checkbox" name="hobby" value="hiking">hiking
						<input type="checkbox" name="hobby" value="coding">coding
						<input type="checkbox" name="hobby" value="basketball">basketball
					</td>
				</tr>
				<tr>
					<td>Information:</td>
					<td><textarea name="info" rows="3" cols="80">${stu.info }</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
		<a href="index.html"><button>Go Home</button></a>
	</center>
</body>
</html>