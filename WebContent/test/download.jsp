<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- "Content-Disposition", "attachment; filename="+fileName
 -->
<title>downloadPage test for response</title>
</head>
<body>
	<div>
		a 链接的方式 <br> <a href="../file/read.txt"> 下载文件 read.txt</a> <br>
		<a href="../file/read.properties"> 下载文件 read.txt</a> <br>
	</div>
	<br>
	<div>
		response 方式 <br> <a href="/WebWay/downloadDemo?fileName=想.txt"> 下载文件 read.txt</a> <br>
		<a href="/WebWay/downloadDemo?fileName=read.properties"> 下载文件 read.txt</a> <br>
	</div>
</body>
</html>