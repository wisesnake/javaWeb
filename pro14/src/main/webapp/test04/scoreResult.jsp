
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="score" value="${param.score}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.score >= 0 && param.score <= 100}">
		<c:choose>
			<c:when test="${param.score > 90 }">
				<c:set var="grade" value="A"></c:set>
			</c:when>
			<c:when test="${param.score <= 90 && param.score > 80}">
				<c:set var="grade" value="B"></c:set>
			</c:when>
			<c:when test="${param.score <= 80 && param.score > 70}">
				<c:set var="grade" value="C"></c:set>
			</c:when>
			<c:when test="${param.score <= 70 && param.score > 60}">
				<c:set var="grade" value="D"></c:set>
			</c:when>
			<c:when test="${param.score <= 60}">
				<c:set var="grade" value="F"></c:set>
			</c:when>
		</c:choose>
		<h3>
		 점수 : ${param.score}<br>
			당신의 등급은
			<c:out value="${grade }"></c:out>
			입니다.
		</h3>
	</c:when>
	<c:otherwise>
		<h3>
			점수 : ${param.score}<br>
			점수를 잘못 입력했습니다.<br>
			<a href="scoreTest.jsp">재입력</a>
		</h3>
	</c:otherwise>
</c:choose>
</body>
</html>