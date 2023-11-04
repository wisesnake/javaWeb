<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
/*  
HttpSession session =  request.getSession(); 해준적도 없는데
session 객체가 자동으로 생성되어 세션에 접근 가능한 모습.
*/
String menu = (String)session.getAttribute("menu");

application.setAttribute("night", "맥주");


/* 
session 같은 브라우저에서 공유
/application 같은 웹 앱에서 공유
*/

request.setAttribute("name", "임슬범");

RequestDispatcher dispatch = request.getRequestDispatcher("session2.jsp");
dispatch.forward(request,response);
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=menu %>

<a href="session2.jsp">두번째 페이지로 이동.</a>

</body>
</html>