<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = request.getParameter("msg");
		if(msg!=null){
	%>
	<h1><%=msg %></h1>
	<%
		}
	%>
	<!-- 
	최초에는 msg가 null이기 때문에 안뜨지만 두번째 아이디 잘못 입력한 순간부터 포워딩으로 msg 받아와 초기화시키므로 
	이후 차시부터는 메세지가 출력될 예정
	  -->
	<form action="result2.jsp"  method="post">
   아이디:  <input type="text"  name="userID"><br>
   비밀번호:  <input type="password"  name="userPw"><br>
   <input type="submit"  value="로그인">
   <input type="reset"  value="다시입력">
</form>
</body>
</html>