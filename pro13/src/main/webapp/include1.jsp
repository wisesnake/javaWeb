<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="/cat_image.jsp">

		<jsp:param value="meeeeeow" name="cat" />
		<jsp:param value="하하" name="cat2" />
	</jsp:include>



<%-- <jsp:useBean id=""></jsp:useBean>

<jsp:setProperty property="" name=""/>
<jsp:getProperty property="" name=""/>



<jsp:forward page=""></jsp:forward> --%>
</body>
</html>