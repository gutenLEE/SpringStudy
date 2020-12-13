<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자로그인성공</title>
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
            top: 300px;
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
    <section>
        <div class="container">
            <p>관리자 로그인 성공</p>
            <div class="btn"><a href="adminMenu.me">학생 성적관리 이동</a></div>
        </div>
    </section>
    
</body>
</html>