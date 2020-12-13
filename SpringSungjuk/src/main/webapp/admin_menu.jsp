<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Optional" %>
<%@ page import="java.lang.System" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "com.spring.springSungjuk.SungjukVO"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학생성적관리</title>
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
            width: 600px;
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
	ArrayList<SungjukVO> student = (ArrayList<SungjukVO>)request.getAttribute("student");
%>
        <table class="student-table">
            <colgroup>
                <col class="hakbun" style="width: 130px;">
                <col class="name" style="width: 130px;">
                <col class="sungjuk-list update" style="width: 80px;">
                <col class="sungjuk-list delete" style="width: 80px;">
            </colgroup>
            <div class="student-table-header">
                <h4>학생 목록</h4>
                <a href="selectAll.me">전체 성적 조회</a>
                <a href="adminInsert.me">학생 입력</a>
            </div>
            <tr class="colgroup">
                <th scope="col" class="hakbun">학번</th>
                <th scope="col" class="name">이름</th>
                <th scope="col" class="sungjuk-list delete">성적입력</th>
                <th scope="col" class="sungjuk-list update">조회</th>
                <th scope="col" class="sungjuk-list delete">삭제</th>
            </tr>
            <%
            	try
            	{	
	            	for(int i = 0; i < student.size(); i++)
	            	{
           	%>
			         <tr class="student-list-row">
			            <td> <%=student.get(i).getHakbun() %> </td>
			            <td> <%=student.get(i).getIrum() %>  </td>
			            <td><a href="sungjukForm.me?hakbun=<%=student.get(i).getHakbun()%>&irum=<%=student.get(i).getIrum()%>">성적입력</a></td>
			            <td><a href="adminSelect.me?hakbun=<%=student.get(i).getHakbun()%>&irum=<%=student.get(i).getIrum()%>">조회</a></td>
			            <!-- <td><a href="adminDelete.me?hakbun=<%=student.get(i).getHakbun()%>&irum=<%=student.get(i).getIrum()%>">삭제</a></td> -->
			            
			            <td><a href="adminDelete.me?hakbun=<%=student.get(i).getHakbun()%>" onclick="return confirm('학생 정보 삭제 시 점수가 모두 삭제됩니다. 실행하시겠습니까?');">삭제</a></td>
			            
			        </tr>
            <%		
            		}
            	}
	            catch(NullPointerException e){ }      
            %>

        </table>

</body>
</html>