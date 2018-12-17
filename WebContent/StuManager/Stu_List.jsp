<%@page import="demo.StuManager.domain.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript">
$(function(){
	/*  写了 一个半小时的废话， 最后这样解决了。。 不等不说 js 的强大 */
	var res= "${gender}";

	$("#s_gender").val(res);
}
)
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
	 	 location.href="/WebWay/SearchStudentServlet?name="+name.val()+"&gender="+gender.val()+"&currentPage=1";	
	 }

</script>
<title>Student List Page</title>
</head>
<body>
	<div class=" container  container-fluid">

		<h1 class="center-block">Student Information System</h1>
		<table class="table table-hover table-striped table-bordered ">
			<tr>
				<td colspan=10>
					<div class="form-group form-inline">
						Search By Name:
						<input type="text" class="form-control " id="s_name" placeholder="some word as you like " value="${name}">
						Search By Gender:
						<select class="form-control" id="s_gender">
							<option>--Chose --</option>
							<!-- 这样写了一晚上 一直是 失败， 我放弃了 这种蠢办法， js 才是最好用的-->
							<%-- 
							<option name="s_gender" value="male"
								selected="${gender eq 'male' ?'selected':'' }">male</option>
							<option name="s_gender" value="female"
								selected="${gender eq 'male' ?'selected':'' }">female</option> --%>
							<option name="s_gender" value="male">male</option>
							<option name="s_gender" value="female">female</option>

						</select>
						<a href="#" class="btn btn-info  " onclick="doSearch()">GO</a>
						<!--  js 添加点击事件 -->
						<a class="btn btn-info pull-right" href="addStudent.jsp">add new line ?</a>
						<!-- 跳转到增加student记录界面 -->
					</div>
				</td>

			</tr>
			<tr>

				<td width="73px">Sid</td>
				<td width="72px">Name</td>
				<td width="63px">Gender</td>
				<td width="93px">Brithday</td>
				<td width="43px">Age</td>
				<td>Address</td>
				<td>Tel</td>
				<td>Hobby</td>
				<td>Info</td>
				<td width="170px">Option</td>
			</tr>
			<c:forEach var="stu" items="${pageBean.list }">
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
					<td><a class="btn btn-primary  " href="/WebWay/EditStudentServlet?sid=${stu.sid}">Update</a> <a class="btn btn-danger   " href="#" onclick="doDelete(${stu.sid})">Delete&nbsp;</a></td>

				</tr>
			</c:forEach>
			<tr>
				<td colspan=10>
					<div type="button" class="btn  btn-success pull-left" disabled="disabled">Now in :&nbsp;&nbsp;&nbsp;</div> &nbsp;
					<div type="button" class="btn  btn-success " disabled="disabled">${pageBean.currentPage}&nbsp;/&nbsp;${pageBean.totalPage}</div>
					<div class="pull-right">
						<a class="btn btn-info" href="/WebWay/SearchStudentServlet?currentPage=1&name=${name}&gender=${gender}">First</a>
						<a class="btn btn-info" href="/WebWay/SearchStudentServlet?currentPage=<c:if test="${pageBean.currentPage>1}">${pageBean.currentPage-1}</c:if>&name=${name}&gender=${gender}">Prev</a>
						<c:forEach var="i" begin="1" end="${pageBean.totalPage}">
							<a class="btn btn-info" href="/WebWay/SearchStudentServlet?currentPage=${i}&name=${name}&gender=${gender}" <c:if test="${i==pageBean.currentPage}">disabled</c:if>>${i}</a>
						</c:forEach>
						<c:if test="${pageBean.currentPage+1 <= pageBean.totalPage}">
							<a class="btn btn-info" href="/WebWay/SearchStudentServlet?currentPage=${pageBean.currentPage+1}&name=${name}&gender=${gender}"> Next</a>
						</c:if>
						<a class="btn btn-info" href="/WebWay/SearchStudentServlet?currentPage=${pageBean.totalPage}&name=${name}&gender=${gender}">Last</a>
					</div>
				</td>
			</tr>
		</table>

	</div>
</body>
</html>