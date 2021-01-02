<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<form action="auth.do" method="post">
		<table border="1" width="450" height="70" align="center">
			<div style="text-align:center">
				<tr>
					<td align="center">
						이메일 : <input type="email" name="email" placeholer="이메일 주소를 입력하세요"/>
						<button type="submit" name="submit">이메일 인증</button>
					</td>
				</tr>
			</div>
		</table>
	</form>
</body>
</html>
