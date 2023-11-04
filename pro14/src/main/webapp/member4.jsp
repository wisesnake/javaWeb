
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sec01.ex01.*" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<jsp:useBean id="vo" class="sec01.ex01.MemberVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo"></jsp:setProperty>

<jsp:useBean id="arrList" class="java.util.ArrayList"></jsp:useBean>

<jsp:useBean id="hashMap" class="java.util.HashMap"></jsp:useBean>

<%
MemberVO member1 = new MemberVO("hong1", "1111", "홍일", "hong1@asdf.asd");
arrList.add(member1);
MemberVO member2 = new MemberVO("hong2", "2222", "홍이", "hong2@asdf.asd");
arrList.add(member2);

hashMap.put("id", "hong3");
hashMap.put("pwd", "3333");
hashMap.put("name", "홍삼");
hashMap.put("email", "hong3@asdf.asd");

arrList.add(2, hashMap);

arrList.add(vo);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
		</tr>
		<c:forEach var="i" begin="0" end="${fn:length(arrList)}" step="1">
			<tr align="center">
				<td width="7%">${arrList[i].id }</td>
				<td width="7%">${arrList[i].pwd }</td>
				<td width="5%">${arrList[i].name }</td>
				<td width="11%">${arrList[i].email }</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>