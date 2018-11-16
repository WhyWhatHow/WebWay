<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Add New One</h1>

		<form action="AddStudentServelt">
			<table border=1>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><input type="radio" name="gender" value="boy" checked="checked">Boy
						<input type="radio" name="gender" value="girl">Girl</td>
				</tr>
				<tr>
					<td>TelPhone:</td>
					<td><input type="text" name="tel"></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><input type="text" name="birthday"></td>
				</tr>
				<tr>
					<td>Hobby:</td>
					<td>
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
					<td><textarea rows="3" cols="80"></textarea></td>
				</tr>
				<tr colspan =2>
					<td ><input type="submit" value="add new line "></td>
				</tr>

			</table>
		</form>
		<a href="index.html"><button>Go Home</button></a>
	</center>
</body>
</html>