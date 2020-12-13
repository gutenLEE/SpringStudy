<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>성적 입력</title>
    <style>
        .student-table-header{
            width: 300px;
            margin: 0 auto;
            text-align: center;
        }
        .student-list-colgroup th{
            border-bottom: 1px solid rgba(0, 0, 0, 0.5);
            padding: 5px 10px;
        }
        table{
            margin: 0 auto;
            width: 300px;
            border: 1px solid black;
        }
        .student-table td{
            text-align: center;
        }
        .student-table h4{
            margin: 10px 3px;
        }
        .student-table input{
            width: 90%;
            height: 23px;
        }
        tr:nth-child(odd):not(.colgroup){
            background: rgba(0, 0, 0, 0.1);
        }
        tr:nth-child(even):not(.colgroup){
            background: white;
        }
        .btn{
            margin: 0 auto;
            width: 500px;
            height: 50px;
        }
        .btn a{
            background: crimson;
            color: white;
            padding: 8px;
            margin: 0 6px;
            border-radius: 3px;
            text-decoration: none;
        }
        .btn a:hover{
            background: gold;
            color: #555;
        }
        .student-list-row{
            height: 40px;
        }
    </style>
    <%
    	String irum = (String)request.getAttribute("irum");
    	String hakbun = (String)request.getAttribute("hakbun");
    %>
</head>
<body>
        <form action="sungjukProcess.me" name="students-list">
            <div class="student-table-header">
                <h4>학생 정보 입력</h4>         
            </div>
            <table class="student-table">            
                <tr class="student-list-col">
                    <td>학번</td>
                    <td><input type="hidden" name="hakbun" value="<%=hakbun%>"><%=hakbun%></td>                 
                </tr>
                <tr class="student-list-col">
                    <td>이름</td>
                    <td><%=irum %></td>       
                </tr>
                <tr class="student-list-col">
                    <td>국어</td>
                    <td><input type="text" name="kor"></td>       
                </tr>
                <tr class="student-list-col">
                    <td>영어</td>
                    <td><input type="text" name="eng"></td>       
                </tr>
                <tr class="student-list-col">
                    <td>수학</td>
                    <td><input type="text" name="math"></td>       
                </tr>
        
                <tr class="student-list-row-btn">
                    <td class="btn" colspan="2">
                    	<input type="submit" value="입력">
                        <a href="javascript:history.back();">취소</a>
                    </td>
                </tr> 
            </table>
        </form>
</body>
</html>