<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<form name="joinform" action="memberinsert.do" method = "post">
		<table border=1>
			<tr>
				<td colspan=2 align=center>
					<b><font size=5> ȸ������ ������</font></b>
				</td>
			</tr>
			<tr>
				<td>���̵� : </td>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<td>��й�ȣ : </td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>�̸� : </td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td colspan=2 align=center>
					<!-- �ζ��� ������ �ڹٽ�ũ��Ʈ �ڵ�. -->
					<a href="javascript:joinform.submit()">ȸ������</a>
					<a href="javascript:joinform.reset()">�ٽ��ۼ�</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>