<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import = "com.spring.springBatis2.MemberVO" %>
<%@ page import = "java.util.*" %>
<%
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
	
%>
<html>
<head>
	<title>Home</title>
</head>
<style>
	table{
		border: 1px solid black;
	}
	tr{
		border: 1px solid black;	
	}
	td{
		width: 80px
	}
	.container{

		width: 711px;
		padding: 10px;
	}
	input[type="submit"]{
		margin-left:100px;
	}

</style>
<body>
<h1>
	Hello world!  
</h1>


<form action="search" method="post">
	<div class="container">
		<input type="checkbox" name="dept" id="salesman" value="SALESMAN"/>
		<label for="salesman"> salesman</label>
		
		<input type="checkbox" name="dept" id="clerk" value="CLERK"/>
		<label for="salesman"> clerk</label>
		
		<input type="checkbox" name="dept" id="analyst" value="ANALYST"/>
		<label for="salesman"> analyst</label>
		
		<input type="checkbox" name="dept" id="manager" value="MANAGER"/>
		<label for="salesman"> manager</label>
	</div>
		<div class="container">
		<input type="checkbox" name="loc" id="dallas" value="DALLAS"/>
		<label for="salesman"> DALLAS</label>
		
		<input type="checkbox" name="loc" id="chicago" value="CHICAGO"/>
		<label for="salesman"> CHICAGO</label>
		
		<input type="checkbox" name="loc" id="newyork" value="NEW YORK"/>
		<label for="salesman"> NEWYORK</label>
		
		<input type="submit" value="조회"/>
	</div>
</form>

<table>
<%
	for(int i = 0; i < list.size(); i++)
	{
		MemberVO vo = list.get(i);
%>
	<tr>
		<td><%=vo.getEmpno() %></td>
		<td><%=vo.getEname() %></td>
		<td><%=vo.getJob() %></td>
		<td><%=vo.getMgr() %></td>
		<td style="width:200px"><%=vo.getHiredate() %></td>
		<td><%=vo.getDname() %></td>
		<td><%=vo.getLoc() %></td>
	</tr>
<%
	} 
%>
</table>
<script>
	
	window.addEventListener('DOMContentLoaded', function(){
	
	    //이벤트 위임
	    const ContainerElem = document.querySelector('.container');
	    console.log(ContainerElem);
	
	    function clickHandler(event) {
	       	var target = event.target.value;
	        console.log(target);
	        
	        jQuery.ajax({
	        	url : '/springBatis2/select',
	        	type : 'post',
	        	data : target,
	        	contentType : 'application/x-www-form-urlencoded;charset=utf-8',
	        	dataType : 'json', //서버에서 보내줄 데이터 타입
	        	success: function()
	        })
	        
	        
	    }
	    
	    ContainerElem.addEventListener('change', clickHandler);
	
	});
		
</script>
</body>
</html>
