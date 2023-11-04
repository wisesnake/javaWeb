<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = "아이디를 입력하지 않음. 아이디 입력 요망.";
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String user_id = request.getParameter("user_id");

	if (user_id == null || user_id.length() == 0) {
	%>
	<jsp:forward page="login2.jsp">
	<jsp:param value="<%=msg %>" name="msg"/>
	</jsp:forward>
	<%
	}
	%>
	<h1>환영합니다. <%=user_id %>님</h1>
</body>
</html>