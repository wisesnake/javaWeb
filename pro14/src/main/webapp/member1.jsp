<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="sec01.ex01.*"%>
<jsp:useBean id="vo" class="sec01.ex01.MemberVO"></jsp:useBean>
<jsp:useBean id="dao" class="sec01.ex01.MemberDAO"></jsp:useBean>
<jsp:setProperty property="*" name="vo" />

<%
	request.setAttribute("nightMenu", "치킨");
%>


<%
dao.addMember(vo);
//bean m을 매개변수로 회원가입메서드 실행
List<MemberVO> membersList = dao.listMembers();
//이후 확인 위해 DB메모리 DAO통해 뽑아옴.
%>

<jsp:forward page="member2.jsp"></jsp:forward>

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



		<tr align="center">
			<td>${param.id }</td>
			<td>${param.pwd }</td>
			<td>${param.name }</td>
			<td>${param.email }</td>
			<!-- memberForm.jsp에서 건너온 파라미터를 키값으로 읽는 EL -->
		</tr>
	</table>
</body>
</html>