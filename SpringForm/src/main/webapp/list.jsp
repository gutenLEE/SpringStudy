<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.spring.springform.EmpVO" %>
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
			<th>mgr</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>comm</th>
			<th>deptno</th>
			<th>삭제</th>
			<th>수정</th>
		<tr>

<%
	// request.getAttribute 반환 객체 타입이 object여서 캐스팅해줌.
	ArrayList<EmpVO> list = (ArrayList<EmpVO>)request.getAttribute("list");

	for(int i = 0; i < list.size(); i++){
		EmpVO empvo = (EmpVO)list.get(i);
%>
		<tr>
			<th><%=empvo.getEmpno() %></th>
			<th><%=empvo.getEname() %></th>
			<th><%=empvo.getJob() %></th>
			<%
				if(empvo.getMgr()==0){
			%>
				<td>&nbsp;</td>
			<%} else {%>
				<td>&nbsp;<%=empvo.getMgr() %></td>
			<%} %>
			<th><%=empvo.getHiredate() %></th>
			<th><%=empvo.getSal() %></th>
			<th><%=empvo.getComm() %></th>
			<th><a href="selectDept.me?deptno=<%=empvo.getDeptno() %>"><%=empvo.getDeptno() %></a>
			<th><a href="deletee.me?empno=<%=empvo.getEmpno() %>">삭제</a>
			<th><a href="selectUpdate.me?empno=<%=empvo.getEmpno() %>">수정</a>
		</tr>
<%
	}
%>
</table>	
</body>
</html>