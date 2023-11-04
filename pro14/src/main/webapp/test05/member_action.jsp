<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sec01.ex01.*" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="vo" class="sec01.ex01.MemberVO"/>
<jsp:setProperty property="*" name="vo"/>
<%
	MemberDAO dao = new MemberDAO();
	dao.addMember(vo);
	List memberList = dao.listMembers();
	request.setAttribute("memberList", memberList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=memberList %>
	<jsp:forward page="memberList.jsp"/>
</body>
</html>