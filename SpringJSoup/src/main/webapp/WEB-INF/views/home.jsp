<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="java.util.ArrayList" %>
<%
	String title = (String)request.getAttribute("title");
	ArrayList<String> list_text = (ArrayList<String>)request.getAttribute("list_text");
	ArrayList<String> list_link = (ArrayList<String>)request.getAttribute("list_link");
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	크롤링
</h1>

<a href="crawl.do">네이버 스포츠 크롤링</a>
</body>
</html>
