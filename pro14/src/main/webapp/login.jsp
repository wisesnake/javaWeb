<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!-- 디렉티브태그 태그라이브 : lib에 taglibs jar 넣고, 위와같이 잡아주면 core 태그 라이브러리(c:) 사용가능. -->

<%
List<String> dataList = new ArrayList<>();
dataList.add("hong1");
dataList.add("hong2");
dataList.add("hong3");
dataList.add("hong4");

%>

<c:set var="list" value="<%=dataList%>"></c:set>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
dataList = <%=dataList %><br>
	<form action="result.jsp">
		아이디 : <input type="text" name="user_id">
		<hr>
		패스워드 : <input type="password" name="user_pw"><br> <input
			type="submit" value="로그인" />
		<p>
			<br> <a href="${contextPath}/memberForm.html">회원가입</a>
	</form>
<hr>
	<!-- 참만 있음. -->
	<c:if test="true">hi</c:if>
	<br>
	<!-- 참과 거짓. -->
	<c:choose>
		<c:when test="false">hi</c:when>
		<c:otherwise>not hi </c:otherwise>
	</c:choose>
	<hr>
	<c:forEach var="i" begin="1" end="10">
		${i}<br>
	</c:forEach>
	<hr>
	<c:forEach var="i" begin="1" end="10" step="2">
		${i}<br>
	</c:forEach>
	<hr>
	
	<c:forEach var="i" items="${list}">
		${i}<br>
	</c:forEach>
	<hr>
	<c:set var="menu" value="치킨, 골뱅이, 곱창, 육회, 전어회"></c:set>
	<c:forTokens items="${menu }" var="token" delims=","><!-- delim = 구분자 -->
	${token }<br>
	</c:forTokens>
</body>
</html>