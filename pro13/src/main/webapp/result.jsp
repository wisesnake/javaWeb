<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	아이디 입력안함.
	<%
	} else {
	RequestDispatcher disp = request.getRequestDispatcher("result2.jsp");
	disp.forward(request, response);
	}
	%>
</body>
</html>