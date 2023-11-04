<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String cat = request.getParameter("cat"); 
	String cat2 = request.getParameter("cat2"); 
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cat_image</title>
</head>
<body>
	<img src="./image/cat1.jpg" width="50%"/><br>
	이것은 <%= cat %> 하고 웁니다.<br>
	이것은 <%= cat2 %> 하고 웁니다.
</body>
</html>