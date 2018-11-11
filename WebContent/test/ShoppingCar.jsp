<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Phone Car</title>
<style type="text/css">

</style>
</head>
<body>
	 <h1 >Shopping Phone Car !</h1>
	
	<br>
		<table border = 1  >
		<tr> <td>Phone Name</td><td> Num : </td></tr>
		<c:forEach  var ="goods" items="${shoppingCar}">
			<tr>
				<td>${goods.key}</td>
				<td>${goods.value}</td>
			</tr>
		</c:forEach>
		</table>
	
	 <!--  返回购物列表 -->
	<a href = "/WebWay/test/PhoneList.jsp"><h3>return to Phone List's Page</h3></a>
	
</body>
</html>