<%@page import="org.apache.catalina.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty param.user_id }">
			아이디를 입력해 주십시오<br>
			<a href="coreLogin.jsp">로그인창으로 돌아가기</a>
		</c:when>
		<c:otherwise>
			<c:if test="${param.user_id eq 'admin' }">
			안녕하세요 <c:out value="${param.user_id }"></c:out>님 <br>
			관리자로 로그인합니다.
			</c:if>
			<c:if test="${param.user_id ne 'admin' }">
			환영합니다! <c:out value="${param.user_id }"></c:out> 님!
			</c:if>
		</c:otherwise>
	</c:choose>

</body>
</html>