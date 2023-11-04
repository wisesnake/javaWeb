<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<head>
   <meta charset="UTF-8">
   <title>글보기</title>
   <style>
     #tr_btn_modify{
       display:none;
     }
   
   </style>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <script type="text/javascript" >
     function backToList(obj){
	    obj.action="${contextPath}/board/listArticles.do";
	    obj.submit();
     }
 
	 function fn_enable(obj){
		 document.getElementById("i_title").disabled=false;
		 document.getElementById("i_content").disabled=false;
		 document.getElementById("i_imageFileName").disabled=false;
		 //수정하기를 누르는순간 읽기전용이었던(textarea) 제목 내용 이미지파일등이
		 //읽기전용이 풀리고 수정이 가능해짐.
		 document.getElementById("tr_btn_modify").style.display="block";
		 document.getElementById("tr_btn").style.display="none";
		 //그리고 수정하기를 누르기 전 수정하기 버튼은 없애고, 똑같은 수정하기 버튼을
		 //만들되, 두번째로 생성된 수정하기 버튼은 컨트롤러에 수정 요청을 보내도록 바뀜.
		 //그게 바로 밑에 선언되어있는 뽱숀임.
	 }
	 
	 function fn_modify_article(obj){
		 obj.action="${contextPath}/board/modArticle.do";
		 obj.submit();
	 }
	 
	 function fn_remove_article(url,articleNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var articleNOInput = document.createElement("input");
	     articleNOInput.setAttribute("type","hidden");
	     articleNOInput.setAttribute("name","articleNO");
	     articleNOInput.setAttribute("value", articleNO);
		 //삭제버튼 누르면 삭제.do 에 액션이 걸려있고, input의 속성으로써
		 //히든과, 키발류로써 네임:밸류 '번호' : 번호 걸려있는 속성 바인드해서
		 //form형태로써 보냄. 컨트롤러에서 request 객체를 통해 받고서 삭제하는데
		 //필요한 정보들을 얻을 수 있도록
	     form.appendChild(articleNOInput);
	     document.body.appendChild(form);
		 form.submit();
	 
	 }
	 function readURL(input) {
	     if (input.files && input.files[0]) {
	         var reader = new FileReader();
	         reader.onload = function (e) {
	             $('#preview').attr('src', e.target.result);
	         }
	         //이 코드는 파일 입력 필드에서 이미지 파일을 선택할 때 이미지 파일의 미리보기를 
	         //생성하는 역할을 합니다. 이벤트 핸들러 함수에서 e.target.result를 사용하여 
	         //파일 리더(FileReader)에서 읽은 이미지 데이터의 URL을 가져옵니다.
	         //이 URL은 선택한 이미지 파일의 미리보기 이미지로 설정됩니다.
	         
	         //e는 이벤트 객체, e.target은 해당 이벤트의 타겟 엘리먼트이며
	         //result는 파일 리더가 읽어들인 데이터의 URL을 가리킴.
	         //이 URL은 이미지 파일을 미리보기로 표시하는 <img> 엘리먼트의 src 속성에 할당됩니다.
	         reader.readAsDataURL(input.files[0]);
	     }
	 }  
 </script>
</head>
<body>
  <form name="frmArticle" method="post"  action="${contextPath}"  enctype="multipart/form-data">
  <table  border="0"  align="center">
  <tr>
   <td width="150" align="center" bgcolor="#FF9933">
      글번호
   </td>
   <td >
    <input type="text"  value="${article.articleNO }"  disabled />
    <input type="hidden" name="articleNO" value="${article.articleNO}"  />
   </td>
  </tr>
  <tr>
   <td width="150" align="center" bgcolor="#FF9933">
      작성자 아이디
   </td>
   <td >
    <input type=text value="${article.id }" name="writer"  disabled />
   </td>
  </tr>
  <tr>
   <td width="150" align="center" bgcolor="#FF9933">
      제목 
   </td>
   <td>
    <input type=text value="${article.title }"  name="title"  id="i_title" disabled />
   </td>   
  </tr>
  <tr>
   <td width="150" align="center" bgcolor="#FF9933">
      내용
   </td>
   <td>
    <textarea rows="20" cols="60"  name="content"  id="i_content"  disabled />${article.content }</textarea>
   </td>  
  </tr>
 
<c:if test="${not empty article.imageFileName && article.imageFileName!='null' }">  
<tr>
   <td width="150" align="center" bgcolor="#FF9933" rowspan="2">
      이미지
   </td>
   <td>
     <input  type= "hidden"   name="originalFileName" value="${article.imageFileName }" />
    <img src="${contextPath}/download.do?articleNO=${article.articleNO}&imageFileName=${article.imageFileName}" id="preview"  /><br>
       
   </td>   
  </tr>  
  <tr>
    <td>
       <input  type="file"  name="imageFileName " id="i_imageFileName"   disabled   onchange="readURL(this);"   />
    </td>
  </tr>
 </c:if>
  <tr>
	   <td width=20% align=center bgcolor=#FF9933>
	      등록일자
	   </td>
	   <td>
	    <input type=text value="<fmt:formatDate value="${article.writeDate}" />" disabled />
	   </td>   
  </tr>
  <tr id="tr_btn_modify" >
	   <td colspan="2"   align="center" >
	       <input type=button value="수정반영하기"   onClick="fn_modify_article(frmArticle)"  >
         <input type=button value="취소"  onClick="backToList(frmArticle)">
	   </td>   
  </tr>
    
  <tr  id="tr_btn"    >
   <td colspan=2 align=center>
	    <input type=button value="수정하기" onClick="fn_enable(this.form)">
	    <input type=button value="삭제하기" onClick="fn_remove_article('${contextPath}/board/removeArticle.do', ${article.articleNO})">
	    <input type=button value="리스트로 돌아가기"  onClick="backToList(this.form)">
	     <input type=button value="답글쓰기"  onClick="fn_reply_form('${contextPath}/board/replyForm.do', ${article.articleNO})">
   </td>
  </tr>
 </table>
 </form>
</body>
</html>