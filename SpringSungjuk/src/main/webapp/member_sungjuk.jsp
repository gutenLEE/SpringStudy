<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import= "com.spring.springSungjuk.SungjukVO"%>
 <%@ page import="java.util.Optional" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>messi회원 성적</title>
    <style>
        .student-table-header{
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
            width: 500px;
            margin: 0 auto;
            text-align: center;
        }
        .student-table-header h4{
            grid-column-start: 1;
            grid-column-start: 2;
        }
        .student-table-header a {
            align-self: end;
            justify-self: end;
            padding: 10px;
            text-decoration: none;
        }
        .student-table-header a:hover:before{
            color: crimson;
            font-size: 1.2em;
        }
        .student-table-header a::before{
            content: "✚";
        }
        .student-list-colgroup th{
            border-bottom: 1px solid rgba(0, 0, 0, 0.5);
            padding: 5px 10px;
        }
        table{
            margin: 0 auto;
            width: 800px;
            border: 1px solid black;
        }
        .student-table td{
            text-align: center;
        }
        .student-table h4{
            margin: 10px 3px;
        }
        .colgroup{
            background-color: dodgerblue;
            color: white;
            height: 40px;
        }
        tr:nth-child(odd):not(.colgroup){
            background: rgba(0, 0, 0, 0.1);
        }
        tr:nth-child(even):not(.colgroup){
            background: white;
        }
    </style>
</head>
<body>
	<%		
		Optional<SungjukVO> vo = (Optional<SungjukVO>)request.getAttribute("sungjuk");
		String hakbun = (String)request.getAttribute("hakbun");
	%>
        <table class="student-table">
            <colgroup>
                <col class="hakbun" style="width: 130px;">
                <col class="name" style="width: 130px;">
                <col class="sungjuk-list update" style="width: 80px;">
                <col class="sungjuk-list delete" style="width: 80px;">
            </colgroup>
            <div class="student-table-header">
                <h4><%=hakbun %> 성적</h4>
    
            </div>
            <tr class="colgroup">
                <th scope="col" class="hakbun">학번</th>
                <th scope="col" class="name">이름</th>
                <th scope="col" class="math">수학</th>
                <th scope="col" class="kor">국어</th>
                <th scope="col" class="eng">영어</th>
                <th scope="col" class="tot">총점</th>
                <th scope="col" class="avg">평균</th>
                <th scope="col" class="grade">성적</th>
            </tr>
            <%
            if(vo.isPresent())
            {
           	%>
            <tr class="student-list-row">
                <td><%=vo.get().getHakbun() %></td>
                <td><%=vo.get().getIrum() %></td>
                <td><%=vo.get().getMath()  %></td>
                <td><%=vo.get().getKor() %></td>
                <td><%=vo.get().getEng() %></td>
                <td><%=vo.get().getTot()  %></td>
                <td><%=vo.get().getAvg() %></td>
                <td><%=vo.get().getGrade() %></td>
            </tr>
            <%} %>
        </table>
</body>
</html>