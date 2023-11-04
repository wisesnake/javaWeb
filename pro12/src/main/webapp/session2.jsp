<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
/*  
HttpSession session =  request.getSession(); 해준적도 없는데
session 객체가 자동으로 생성되어 세션에 접근 가능한 모습.
*/
String menu = (String)application.getAttribute("night");
String name = (String)request.getAttribute("name");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=menu %><br>
<%=name %><br>


<a href="session1.jsp">첫번째 페이지로 이동.</a>
</body>
</html>