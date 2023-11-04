<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<jsp:useBean id="vo" class="sec01.ex01.MemberVO"></jsp:useBean>
<jsp:setProperty property="id" name="vo" value="choi" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${vo}<br>
${vo.id}<br>


${empty ""}<br>
${empty null}<br>
<hr>


	${100+1}
	<br> ${100-1}
	<br> ${100*2}
	<br> ${100/3}
	<br> ${100 mod 3}
	<br> ${100 % 3}
	<br>
	<hr>
	${"hi"}
	<br> ${"안뇽"}
	<br>
	<hr>
	${5 == 5}
	<br> ${5 eq 5}
	<br> ${hi eq hi}
	<br>
	<hr>
	${5 != 5}
	<%-- 	<br> ${5 ne 5} --%>
	<br>
	<hr>
	${6 >= 5}
	<br> ${6 gt 5}
	<br>
	<hr>
	${6 <= 5}
	<br> ${6 lt 5}
	<br>
	<hr>
	${true && true}
	<br> ${true && true}
	<br> ${false && true}
	<br> ${false && false}
	<br>
	<hr>
	${true || true}
	<br> ${true || true}
	<br> ${false || true}
	<br> ${false || false}
	<br>


</body>
</html>