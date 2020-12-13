<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "javax.sql.*" %>
<%@ page import = "javax.naming.*" %>

<%
	String id = null;  
    
	if( (session.getAttribute("id") == null) || !(((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		/* 커넥션 풀을 활용한 객체 할당받기 */
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		String sql = "SELECT * FROM member";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();		

	}catch(Exception e){
		e.printStackTrace();
	}
%>

<html>
<head>
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
</head>
<body>
	<table border=1 width=300>
		<tr align=center>
			<td colspan = 3>회원목록</td>
		</tr>
		<% while(rs.next()){ %>
			<tr align=center>
				<td>
					<a href="member_info.jsp?id=<%=rs.getString("id") %>">
						<%=rs.getString("id") %>
					</a>
				</td>
				<td><a href="member_delete.jsp?id=<%=rs.getString("id") %>">삭제</a></td>
				<td><a href="member_updateForm.jsp?id=<%=rs.getString("id") %>">수정</a></td>
			</tr>
			<%} %>
	</table>
</body>
</html>




