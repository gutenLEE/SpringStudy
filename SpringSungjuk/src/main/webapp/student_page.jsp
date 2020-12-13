<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Optional" %>
<%@ page import= "com.spring.springSungjuk.SungjukVO"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학생로그인성공</title>
    <style>
        section{
            display: flex;
            position: relative;
            top: 80px;
            height: 50vh;
            justify-content: center;
            align-items: center;
 
        }
        .container{
            background-color: rgba(180, 6, 12, 0.5);
            width: 300px;
            height: 400px;
            border-radius: 5px;
        }
        .btn{
            font-size: 1.5em;
            position: absolute;
            top: 200px;
            margin: 42px;
            color: white;
        }
        .container p{
            margin: 40px;
            font-size: 1em;
            color: white;
        }
        a{
            text-decoration: none;
            color: white;
        }
        a:hover{
            color: gray;
        }
    </style>
</head>
<body>
	<%
		Optional<SungjukVO> vo = (Optional<SungjukVO>)request.getAttribute("sungjuk");
		if(vo.isPresent()){
	%>
		<section>
	        <div class="container">
	            <p> <%=session.getAttribute("hakbun") %> 학생 로그인 성공</p>
	            <div class="btn">
	            	<p><%=vo.get().getGrade() %></p>
	            	<a href="./member_sungjuk.me"> 성적 상세 조회</a>
	            </div>
	        </div>
	    </section>
	<%		
		} else{
	%>		
		<section>
	        <div class="container">
	            <p> <%=session.getAttribute("hakbun") %> 학생 로그인 성공</p>
	            <div class="btn">
	            	<p>성적 처리 중....</p>
	            	<a href="./member_sungjuk.me">뒤로 가기</a>
	            </div>
	        </div>
	    </section>
	<%} %>
    
    
</body>
</html>