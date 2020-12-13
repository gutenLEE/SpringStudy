<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "java.util.*, com.spring.springmybatis.*" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html charset= utf-8">
<title>Insert title here</title>

<script language="javascript">
	function res()
	{
		location.href = "list.do";
	}

</script>
</head>
<body>
	<form method = "post" action="update.do">
		<input type="hidden" name="id" id="id" value=${member.id }>
		<table border="1" align="center">
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>이메일</td>
				<td>전화</td>
				<td align="center"> <input type="button" value="리스트" onclick="res()"> </td>
			</tr>
			<tr>
				<td> 
					${member.id } 
					<input type="hidden" name="name" id="name" value=${member.id }>
				</td>
				<td><input type="text" name="name" id="name" value=${member.name }></td>
				<td><input type="text" name="email" id="email" value=${member.email }></td>
				<td><input type="text" name="phone" id="phone" value=${member.phone }></td>
				<td align="center"> <input type="submit" value="추가" > </td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="수정">
					<input type="button" value="리스트" onclick="res()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>