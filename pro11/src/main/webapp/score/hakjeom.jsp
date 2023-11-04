<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
int score = Integer.parseInt(request.getParameter("score")); 
String grade = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hakjeom</title>
</head>
<body>
	<%
		
		if(score > 90){
			grade = "A";
		}else if(score < 90 && score > 80){
			grade = "B";
		}else if(score < 80 && score > 70){
			grade = "C";
		}else if(score < 70 && score > 60){
			grade = "D";
		}else if(score < 60){
			grade = "F";
		}
	%>
	입력받은 점수는 : <%=score %> 입니다.
	<hr>
	성적 : <%=grade %>
	
</body>
</html>