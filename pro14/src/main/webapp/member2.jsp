<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%-- <%
	String menu = (String)request.getAttribute("nightMenu");
%> --%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${nightMenu}
<!-- 
그냥 forward로 attribute를 타고 들어온 param을 키만 입력해서 
불러 올 수 있는 예시 
위와 같은 사용은 액션태그 forward로 넘어온  attribute에만 적용가능
일반 input등으로 넘어온 파라미터는 안됨.
-->

</body>
</html>