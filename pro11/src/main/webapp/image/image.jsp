<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
td{
	text-align : center;
}
</style>
<body>
	<table align="center" border=1>
		<%
		for (int i = 0; i < 4; i++) {
		%>
		<tr>
			<td width = "300px"><img src="cat<%=i + 1%>.jpg" width="100%"></td>
			<td width = "300px"> 이 사진은 <%=i+1%> 번째 고양이 입니다.</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>