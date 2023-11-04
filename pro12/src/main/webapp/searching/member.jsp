<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="sec02.ex01.*"%>

<%
request.setCharacterEncoding("utf-8");
String _name = request.getParameter("name");
MemberDAO dao = new MemberDAO();
MemberVO vo = new MemberVO();
vo.setName(_name);
//일단 검색을 위해, DAO의 listMembers의 매개변수가 MemberVO 타입이므로,
//vo 객체 만들어서 거기다가 검색창에 입력하여 넘어온 매개값을 setName으로 넣어두고
//전달하여 해당 vo객체의 name과 동일한 name을 가진 DB를 검색할 때 쓰기 위한 것.
List<MemberVO> list = dao.listMembers(vo);
//DAO 서블릿에 짜놓은 로직대로, _name에 들어간 검색 회원 이름과 동일한 레코드를
//리턴받아 list변수에 초기화.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 출력</h1>
	<table border='1' width='800' align='center'>
		<tr align='center' bgcolor='#FFFF66'>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>가입일자</td>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
			MemberVO currVO = list.get(i);
			String id = currVO.getId();
			String pwd = currVO.getPwd();
			String name = currVO.getName();
			String email = currVO.getEmail();
			Date joinDate = currVO.getJoinDate();
		%>
		<tr align='center'>
			<td><%=id%></td>
			<td><%=pwd%></td>
			<td><%=name%></td>
			<td><%=email%></td>
			<td><%=joinDate%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>