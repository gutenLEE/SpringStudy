<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>�α���</title>
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
                    <td>�й�</td>
                    <td><input type="text" name="hakbun"></td>
                </tr>
                   <tr>
                    <td>�̸�</td>
                    <td><input type="text" name="irum"></td>
                </tr>
                <tr>
                    <td>��й�ȣ</td>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td id="table-login-btn">
                        <a href="javascript:joinform.submit()">ȸ������</a>
						<a href="javascript:joinform.reset()">�ٽ��ۼ�</a>
                    </td>
                </tr>
            </table>
        </form>
    </section>
</body>
</html>