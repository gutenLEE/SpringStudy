<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import = "com.spring.springBatis2.MemberVO" %>
<%@ page import = "java.util.*" %>
<%
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
	
%>
<html>
<head>
	<title>Home</title>
</head>
<style>
	table{
		border: 1px solid black;
	}
	tr{
		border: 1px solid black;	
	}
	td{
		width: 80px
	}
	.container{

		width: 711px;
		padding: 10px;
	}
	input[type="submit"]{
		margin-left:100px;
	}

</style>
<body>
<h1>
	Hello world!  
</h1>

<table>
<%
	for(int i = 0; i < list.size(); i++)
	{
		MemberVO vo = list.get(i);
%>
	<tr>
		<td><%=vo.getEmpno() %></td>
		<td><%=vo.getEname() %></td>
		<td><%=vo.getJob() %></td>
		<td><%=vo.getMgr() %></td>
		<td style="width:200px"><%=vo.getHiredate() %></td>
		<td><%=vo.getDname() %></td>
		<td><%=vo.getLoc() %></td>
	</tr>
<%
	} 
%>
	
</table>
</body>
</html>
