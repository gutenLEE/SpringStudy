<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello world! file upload</h1>
	<form id="multiform" action="fileUpload2.bo" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name = "name"> <br><br>
		파일 : <input type="file" name = "file" multiple="multiple"> <br><br>
		<input type="button" value="다중업로드1" onclick="fnAction('fileUpload1.bo')">
		<input type="button" value="다중업로드2" onclick="fnAction('fileUpload2.bo')">
	</form>
	
	<script>
		function fnAction(url){
			var frm = document.getElementById('multiform');
			frm.action = url;
			frm.submit();
		}
	</script>
</body>
</html>