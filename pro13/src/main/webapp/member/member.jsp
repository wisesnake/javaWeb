<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,sec01.ex01.*" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="vo" class="sec01.ex01.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="vo" />

<!-- 
위의 단 두줄이 대체한 코드

MemberBean vo = new MemberBean(id, pwd, name, email);

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");
String email = request.getParameter("email");

vo.setId(id);
vo.setPwd(pwd);
vo.setName(name);
vo.setEmail(email); 


-->
<!-- vo 객체 생성.  -->
<%--
<jsp:setProperty property="id" name="vo"/>
<jsp:setProperty property="pwd" name="vo"/>
<jsp:setProperty property="name" name="vo"/>
<jsp:setProperty property="email" name="vo"/> 
--%>

<%-- 
<jsp:setProperty property="id" name="vo" param="id"/>
<jsp:setProperty property="pwd" name="vo" param="pwd"/>
<jsp:setProperty property="name" name="vo" param="name"/>
<jsp:setProperty property="email" name="vo" param="email"/>
--%>

<%

MemberDAO memberDAO = new MemberDAO();
memberDAO.addMember(vo);
//bean m을 매개변수로 회원가입메서드 실행
List membersList = memberDAO.listMembers();
//이후 확인 위해 DB메모리 DAO통해 뽑아옴.
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
			<td width="5%">가입일</td>
		</tr>
		<%

				if (membersList.size() == 0) {
		%>
		<tr>
			<td colspan="5">
				<p align="center">
					<b><span style="font-size: 9pt;"> 등록된 회원이 없습니다.</span></b>
				</p>
			</td>
		</tr>
		<%

				} else {
				for (int i = 0; i < membersList.size(); i++) {
			MemberBean bean = (MemberBean) membersList.get(i);
		%>
		<tr align="center">
			<td><%=bean.getId()%></td>
			<td><%=bean.getPwd()%></td>
			<td><%=bean.getName()%></td>
			<td><%=bean.getEmail()%></td>
			<td><%=bean.getJoinDate()%></td>
		</tr>
		<%
		} // end for

		} // end if
		%>
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>
</body>
</html>
