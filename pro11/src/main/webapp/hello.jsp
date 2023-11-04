<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String name = "홍길동";

	/* 	public String getName() {
			return name;
		} */%>

<%
request.setCharacterEncoding("utf-8");
int age = Integer.parseInt(request.getParameter("age"));
String hobby = request.getParameter("hobby");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	hi
	<p>
		안뇽~
		<%=name%>
		<br>
		<%!String name2 = "김길동";%>
		안뇽~
		<%=name2%>
		나이는
		<%=age%>
		래요~ <br> 취미는
		<%=hobby%>
		입니다.
	<hr>

</body>
</html>