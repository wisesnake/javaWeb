<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="http://localhost:8090/pro16"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>

$(function() {

	$.ajax({
		type:"post",
		async : "false",
		url : "${contextPath}/json2",
		success:function(data,textStatus){
			var jsonData = JSON.parse(data);
			var memberInfo = "회원정보<br>"
			memberInfo+= "===============<br>"
			console.log(jsonData.members);
			for(var i in jsonData.members){
				memberInfo += "<br>이름 : " + jsonData.members[i].name;
				memberInfo += "<br>나이 : " + jsonData.members[i].age;
				memberInfo += "<br>성별 : " + jsonData.members[i].gender;
				memberInfo += "<br>별명 : " + jsonData.members[i].nickname;
			}
			$("#output").html(memberInfo);
		},
        error: function (data, textStatus) {
            alert("에러발생");
        }
	});
	
});

</script>
</head>


<body>
	<div id="output"></div>
</body>
</html>