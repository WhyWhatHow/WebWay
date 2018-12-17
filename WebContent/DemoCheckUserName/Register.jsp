<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User Page</title>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
function checkUserName(){
	var name = $("#name").val();
	alert(name);
	var url ="/WebWay/CheckNameServlet?name="+name; 
	$.get(url,function(data,status){
		
		if(data.contains("true")){
			
			$("#sp_name").html("恭喜，并不是admin，所以可以使用喔");	
		}else {
			$("#sp_name").html( "sorry ,admin并不对外开放，所以不可以使用喔");	
		}
	});
}
</script>

</head>
<body>
	<table border="1" width="500">
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="name" id="name"
				onblur="checkUserName()"><span id="sp_name"></span></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="text" name=""></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name=""></td>
		</tr>
		<tr>
			<td>简介</td>
			<td><input type="text" name=""></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="注册"></td>
		</tr>
	</table>
</body>
</html>