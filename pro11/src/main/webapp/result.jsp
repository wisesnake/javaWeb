<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("user_id");
String pw = request.getParameter("user_pw");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (id == null || id.length() == 0) {
	%>
	아이디를 입력하십시오.
	<br>
	<a href="login.html">홈으로</a>
	<%
	} else {
	%>
	환영합니다
	<%=id%>님
	<br> 당신의 비밀번호는
	<%=pw%>
	<%
	}
	%>
</body>
</html>