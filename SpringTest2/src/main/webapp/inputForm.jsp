<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />R">
<title>Insert title here</title>
</head>
<body>
	id : ${id} <br>
	pw : ${pw} <br><br>
	jumin : ${jumin} <br>
	gender : ${gender} <br>
	phone : ${phone} <br>
	email : ${email} <br>
	hobby : ${hobby} <br>
	introduce : ${introduce} <br>
	
	id : <%=request.getAttribute("id") %><br>
	pw : <%=request.getAttribute("pw") %><br>
</body>
</html>