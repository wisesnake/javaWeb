<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="title1" value=" hello world! " />
	<c:set var="title2" value="쇼핑몰 중심 JSP입니다!" />
	<c:set var="str" value="중심" />
	
	<h2>여러가지 문자열 함수 기능</h2>
	title1 = "hello world"<br>
	title2 = "쇼핑몰 중심 jsp입니다!"<br>
	str1="중심"<br><br>
	
	fn:length(title1)=${fn:length(title1) } <br>
	<!--  문자열 길이 반환  -->
	fn:toUpperCase(title1)=${fn:toUpperCase(title1)}<br>
	fn:toLowerCase(title1)=${fn:toLowerCase(title1)}<br><br>
	<!-- 대문자, 소문자로 변환  -->
	fn:substring(title1,3,6)=${fn:substring(title1,3,6)}<br>
	<!-- 글자,시작,끝인덱스 으로 문자열의 일부만 반환 -->
	fn:trim(title1)=${fn:trim(title1)}<br>
	<!-- 앞뒤공백제거  -->
	fn:replace(title1," ","/")=${fn:replace(title1," ","/")}<br><br>
	<!-- 2번째 매개값을 세번째로 대체 -->
	fn:indexOf(title2,str1)=${fn:indexOf(title2,str1) }<br>
	<!-- title2문자열에서 str1문자열의 위치 -->
	fn:contains(title1,str1)=${fn:contains(title1,str1) }<br>
	<!-- title1이 str1을 포함하는지 -->
	fn:contains(title2,str1)=${fn:contains(title2,str1) }<br>
	<!-- title2이 str1을 포함하는지 -->
	
</body>
</html>