<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search with Hint!</title>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	/* 实现ajax 放回数据 类型，xml，json */
	$(function() {
		$("#word").keyup(function() {
			var word = $("#word").val();
			if (word == "") {
				$("div_words").hide();

			} else {
				var url = "https://www.baidu.com/s?ie=UTF-8&wd=" + word;
				$.get(url, function(data, status) {
					alert(123);
					$("div_words").hide();
					consloe.log(data);
					$("div_woeds").html(data);
				})

			}
		})
	})
</script>

</head>
<body>
	<center>
		<h2>Service For You, My Load!</h2>
		<input type="text" name="word" id="word"
			style="width: 600px; height: 50px; font-size: 20px;"> <input
			type="button" value="Search (WhyWhatHow)"
			style="height: 55px; width: 200px;">
		<div id="div_words"
			style="position: relative; left: -54px; width: 600px; height: 200px; border: 1px solid blue; display: none">
		</div>
	</center>

</body>
</html>