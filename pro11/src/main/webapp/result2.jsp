<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

String id = request.getParameter("user_id");
String pw = request.getParameter("user_pw");
%>


<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="UTF-8"> -->
<title>Insert title here</title>
</head>
<body>
	<%
	if (id == null || id.length() == 0) {
	%>
	<a href="login.html">다시 로그인 가기</a>
	<%
	} else if (id.equals("admin")) {
	%>
	반갑습니다 관리자님.
	<%
	} else {
	%>
	당신은 관리자가 아니잖아
	<%
	}
	%>
	<a href="login.html">다시 로그인 가기2</a>
</body>
</html>