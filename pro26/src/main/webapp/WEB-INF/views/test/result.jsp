<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>결과창</title>
</head>
<body>
<!-- @RequestParam으로 하나하나 지정해서 보내온경우 -->
<h1>아이디 : ${userID }</h1>
<h1>이름   : ${userName }</h1>

<!-- @RequestParam Map<String,String> info 로 Map으로 보내온경우 -->
<%--  <h1>아이디 : ${info.userID }</h1>
<h1>이름   : ${info.userName }</h1> --%>
</body>
</html>
