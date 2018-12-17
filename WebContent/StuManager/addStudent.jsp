<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet">

<title>Add New Student Information</title>
</head>
<body>
	<div class="container ">

		<h1>Add New One</h1>

		<form class="form-group" action="/WebWay/AddStudentServlet" method="post">
			<table class=" table table-bordered table-hover  table-striped">
				<tr>
					<td>Name:</td>
					<td><input type="text" class="form-control" name="sname"></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><input type="radio" class="radio radio-inline" name="gender" value="male" checked="checked">Boy <input type="radio" class="radio radio-inline" name="gender" value="female">Girl</td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><input type="text" class="form-control" name="age"></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" class="form-control" name="address"></td>
				</tr>
				<tr>
					<td>TelPhone:</td>
					<td><input type="text" class="form-control" name="tel"></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><input type="text" class="form-control" name="birthday"></td>
				</tr>
				<tr>
					<td>Hobby:</td>
					<td><input class="checkbox checkbox-inline" type="checkbox" name="hobby" value="reading">reading <input class="checkbox checkbox-inline" type="checkbox" name="hobby" value="sports">sports
						<input class="checkbox checkbox-inline" type="checkbox" name="hobby" value="movies">movies <input class="checkbox checkbox-inline" type="checkbox" name="hobby" value="hiking">hiking
						<input class="checkbox checkbox-inline" type="checkbox" name="hobby" value="coding">coding <input class="checkbox checkbox-inline" type="checkbox" name="hobby" value="basketball">basketball
					</td>
				</tr>
				<tr>
					<td>Information:</td>
					<td><textarea class="form-control" name="info" rows="3"></textarea></td>
				</tr>
				<tr>
					<td colspan=2><input type="submit" class="btn btn-info center-block" value="Add New One! "></td>

				</tr>
			</table>
		</form>
		<a href="index.html">
			<button class="btn btn-info center-block">Go Home</button>
		</a>
	</div>
</body>
</html>