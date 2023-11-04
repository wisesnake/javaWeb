<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int num1 = Integer.parseInt(request.getParameter("num"));
int maxNum = 9;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=num1%>
		단 까지!
	</h1>
	<table align = 'center' border='1'">
		<%
		for (int i = 1, result; i <= num1; i++) {
			if (i % 2 == 1) {
		%><tr align = 'center' bgcolor="#CCFF66">
			<%
			} else {
			%>
			<tr align = 'center' bgcolor="#CCCCFF">
			<%
			}
			for (int j = 1; j <= maxNum; j++) {
				result = i * j;
			%><td><%=i%> X <%=j%> = <%=result%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>