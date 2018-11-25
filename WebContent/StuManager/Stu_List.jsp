<%@page import="demo.StuManager.domain.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript">
	 function doDelete(sid){
		 var res = confirm("你确定要删除么？");
		 if (res){
			 var url = "http://localhost:8080/WebWay/DeleteStudentServlet?sid="+sid; 
		 	location.href =url;
			 /* $.get(url,function(data,status){
					 alert(123);
					 console.log(data);
					 console.log(status);
				 });  */
				 	 
		 }
	 }
	 function doSearch(){
		 var name= $("#s_name");
		 var gender= $("#s_gender");
		 /* alert(name.val());
		  alert(gender.val());
	 	*/
	 	 location.href="/WebWay/SearchStudentServlet?name="+name.val()+"&gender="+gender.val();	
	 }

</script>
<title>Student List Page</title>
</head>
<body>
	<!-- <div class="main container">
	 -->
	<table border=1>
		<tr>
			<td colspan=10>Search By Name: <input type="text" id="s_name">
				Search By Gender: <select id="s_gender"><option>--Chose
						--</option>
					<option name="s_gender" value="male">male</option>
					<option name="s_gender" value="female">female</option></select> <a href="#"
				class="btn btn-info" onclick="doSearch()">GO</a> <!--  js 添加点击事件 -->
				<a class="btn btn-info right" href="addStudent.jsp">add new line
					?</a> <!-- 跳转到增加student记录界面 -->
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
				<td><a class="btn btn-primary"
					href="/WebWay/EditStudentServlet?sid=${stu.sid}">Update</a> <a
					class="btn btn-danger" href="#" onclick="doDelete(${stu.sid})">
						delete</a></td>

			</tr>
		</c:forEach>

	</table>
	<!-- 
	</div> -->
</body>
</html>