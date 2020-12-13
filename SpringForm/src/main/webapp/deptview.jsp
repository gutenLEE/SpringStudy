<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spring.springform.DeptVO" %>
<%
	DeptVO deptvo = (DeptVO)request.getAttribute("deptvo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>부서번호</td>
		<td>${deptvo['deptno']}</td>
		<td>${deptvo['deptno']}</td>
	</tr>
	<tr>
		<td>부서명</td>
		<td>${deptvo['dname']}</td>
	</tr>
	<tr>
		<td>위치</td>
		<td>${deptvo['loc']}</td>
	</tr>
	<tr>
		<td><a href="selectProcess.me">사원정보</a></td>
	</tr>
</table>
</body>
</html>