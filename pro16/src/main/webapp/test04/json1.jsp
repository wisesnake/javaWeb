<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
	$(function() {

		$("#btn1").click(function() {
			var jsonStr = '{"name": ["홍길동", "김유신", "이순신"]}';
			var jsonInfo = JSON.parse(jsonStr);
			console.log(jsonInfo);
			var output = "회원 이름<br>";
			output += "======<br>";
			for ( var i in jsonInfo.name) {
				output += jsonInfo.name[i] + "<br>";
			}
			$("#output").html(output);
		});

		$("#btn2")
				.click(
						function() {
							var jsonStr = '{"name":"박지성","age":25,"gender":"남자","nickname":"날센돌이"}';
							var jsonInfo = JSON.parse(jsonStr);

							var output = "이름  나이  성별    별명<br>"
							output += "================<br>"
							output += jsonInfo.name + " " + jsonInfo.age + " "
									+ jsonInfo.gender + " " + jsonInfo.nickname;
							$("#output2").html(output);
						});

		$("#btn3")
				.click(
						function() {
							var jsonStr = '{"members":[{"name":"박지성","age":"25","gender":"남자","nickname":"날센돌이"}'
									+ ', {"name":"손흥민","age":"30","gender":"남자","nickname":"탱크"}] }';
							var jsonInfo = JSON.parse(jsonStr);
							var output = "회원 정보<br>";
							output += "=======<br>";
						    for(var i in jsonInfo.members){
					               output += "이름: " + jsonInfo.members[i].name+"<br>";
						       output += "나이: " + jsonInfo.members[i].age+"<br>";
						       output += "성별: " + jsonInfo.members[i].gender+"<br>";
						       output += "별명: " +jsonInfo.members[i].nickname+"<br><br><br>";
						    }
							$("#output3").html(output);

						});

	});
</script>
</head>
<body>
	<input id="btn1" type="button" value="벝언1" />
	<div id="output"></div>
	<hr>
	<input id="btn2" type="button" value="벝언2" />
	<div id="output2"></div>
	<hr>
	<input id="btn3" type="button" value="벝언3" />
	<div id="output3"></div>

</body>
</html>