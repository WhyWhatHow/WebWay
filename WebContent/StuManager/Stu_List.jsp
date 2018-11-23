<%@page import="demo.StuManager.domain.Student"%>
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
<center>
	<table border=1>
		<tr>
		<td colspan=10 >
		 Search By Name: <input type= "text"> 
		 Search By Gender: <select><option>--Chose --</option>
		 <option>  male	</option><option>  female</option></select>
		 <button> GO </button>  <!--  js 添加点击事件 -->
		 <a href ="addStudent.jsp">add new line ?</a> <!-- 跳转到增加student记录界面 -->
		</td>
		
		</tr>
		<tr>
			<td>Sid</td>
			<td>Name</td>
			<td>Gender</td>
			<td>Brithday</td>
			<td>Age</td>
			<td>Address</td>
			<td>Tel</td>
			<td>Hobby</td>
			<td>Info</td>
			<td>Option</td>
		</tr>
		<c:forEach var="stu" items="${list }">
			<tr>
				<td>${stu.sid }</td>
				<td>${stu.sname }</td>
				<td>${stu.gender}</td>
				<td>${stu.birthday}</td>
				<td>${stu.age }</td>
				<td>${stu.address }</td>
				<td>${stu.tel }</td>
				<td>${stu.hobby }</td>
				<td>${stu.info }</td>
				<td>
				<a href ="/WebWay/UpdateStudentServlet?sid=${stu.sid}>">Update</a>
				 <a href ="/WebWay/DeleteStudentServlet?sid=${stu.sid}">delete</a>
				 </td>

			</tr>
		</c:forEach>

	</table>

</center>
</body>
</html>