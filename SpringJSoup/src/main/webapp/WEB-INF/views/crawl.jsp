<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="java.util.ArrayList" %>
<%
	String title = (String)request.getAttribute("title");
	ArrayList<String> list_text = (ArrayList<String>)request.getAttribute("list_text");
	ArrayList<String> list_link = (ArrayList<String>)request.getAttribute("list_link");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th><%=title %></th>
		</tr>

	</table>
</body>
</html>