<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <style>
        .containers{
            display: flex;
            justify-content: center;
            align-items: center;
            height: 30vh;
        }
        table{
            border: 1px solid black;
            height: 120px;
            padding: 0 16px;
        }
        #table-head p{
            display: inline;
            margin: auto;
        }
        #table-login-btn{
            display: block;
            position: relative;
            left: 180px;
            padding: 5px 0;
            background: gold;
            
        }
        #table-login-btn a{
            margin-left:8px ;
            text-decoration: none;
            color: #333333;
        }
        #table-login-btn a:hover{
            margin-left:8px ;
            text-decoration: none;
            color: #dodgerblue;
        }
    </style>
</head>
<body>
    <section class="containers">
        <form action="./joinProcess.me" method="POST" name="joinform">
            <table>
                <tr id="table-head"><p>Bitcamp portal join</p></tr>
                <tr>
                    <td>학번</td>
                    <td><input type="text" name="hakbun"></td>
                </tr>
                   <tr>
                    <td>이름</td>
                    <td><input type="text" name="irum"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td id="table-login-btn">
                        <a href="javascript:joinform.submit()">회원가입</a>
						<a href="javascript:joinform.reset()">다시작성</a>
                    </td>
                </tr>
            </table>
        </form>
    </section>
</body>
</html>