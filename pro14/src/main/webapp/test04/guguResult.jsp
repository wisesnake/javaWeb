
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="dan" value="${param.dan}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table * {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h2>
		입력받은 단수 :
		<c:out value="${dan }"></c:out>
	</h2>
	<table>
		<c:forEach var="i" begin="1" end="9">
			<tr>
				<c:forEach var="j" begin="1" end="${dan }">
					<td>${j} * ${i} = ${i*j}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
<hr>
	<table>
		<c:forEach var="i" begin="1" end="9" step="1">
			<tr>
				<td width="200px" align="center">${dan } * ${i } =</td>
				<td width="100px" align="center">${dan*i }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>