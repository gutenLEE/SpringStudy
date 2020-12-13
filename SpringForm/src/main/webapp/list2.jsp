<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.spring.springform.EmpDeptVo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type"  content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
	th{
		width: 100px;
	}
</style>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>deptno</th>
			<th>hiredate</th>
			<th>dname</th>
			<th>loc</th>
		<tr>
<%
	// request.getAttribute 반환 객체 타입이 object여서 캐스팅해줌.
	ArrayList<EmpDeptVo> list = (ArrayList<EmpDeptVo>)request.getAttribute("list2");

	for(int i = 0; i < list.size(); i++){
		EmpDeptVo empDeptVo = (EmpDeptVo)list.get(i);
%>
		<tr>
			<th><%=empDeptVo.getEmpno() %></th>
			<th><%=empDeptVo.getEname() %></th>
			<th><%=empDeptVo.getJob() %></th>
			<th><a href="selectDept.me?deptno=<%=empDeptVo.getDeptno() %>"><%=empDeptVo.getDeptno() %></th>
			<th><%=empDeptVo.getDname() %></th>
			<th><%=empDeptVo.getLoc() %></th>
			<th><%=empDeptVo.getDeptno() %></th>
			<th><a href="delete2.me?empno=<%=empDeptVo.getEmpno() %>">삭제</a></th>
		</tr>
<%
	}
%>
</table>	
</body>
</html>