<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spring.springform.EmpVO" %>
<!DOCTYPE html>
<html>
<head>
<%
	EmpVO empvo = (EmpVO)request.getAttribute("empvo");
%>

<style>
td{
	width: 100px;
	border: 1px solid black;
}

</style>
<meta http-equiv="Content-type"  content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "updateProcess.me" method="post">
		<table align="center">
			<tr>
				<td>사원 번호</td>
				<td>${empvo['empno']}
					<input type="hidden" value="${empvo['empno']}" name="empno" id="empno">
				</td>
			</tr>
			<tr>
				<td>사원 이름</td>
				<td>${empvo['ename']}</td>
			</tr>
			<tr>
				<td>job</td>
				<td><input type="text" name="job" size="10" maxlength="10" placeholder="${empvo['job']}"></td>
			</tr>
			<tr>
				<td>mgr</td>
				<td><input type="text" name="mgr" size="10" maxlength="10" placeholder="${empvo['mgr']}"></td>
			</tr>
			<tr>
				<td>sal</td>
				<td><input type="text" name="sal" size="10" maxlength="10" placeholder="${empvo['sal']}"></td>
			</tr>
			<tr>
				<td>comm</td>
				<td><input type="text" name="comm" size="10" maxlength="10" placeholder="${empvo['comm']}"></td>
			</tr>
			<tr>
				<td>deptno</td>
				<td><input type="text" name="deptno" size="10" maxlength="2" placeholder="${empvo['deptno']}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>