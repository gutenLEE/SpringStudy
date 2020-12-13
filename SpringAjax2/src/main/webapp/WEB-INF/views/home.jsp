<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
<style>
	form{
		width : 500px;
		margin : 10px auto;
	}
	ul{
		padding : 0;
		margin : 0;
		list-style : none;
	}
	ul li{
		padding : 0;
		margin : 0 0 10px 0;
	}
	label{
		width : 150px;
		float : left;
	}
	table{
		border : 1px solid gray;
		width:500px;
		margin: 0 auto;
		border-collapse: collapse;
	}
	td{
		border : 1px solid black;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	
	//목록
	function selectData(){
		
		$('#output').empty(); // table 내부 내용을 제거 (초기화)
		
		$.ajax({
			url : '/springajax/getPeopleJSON.do',
			type : 'POST',
			// datatype : 'json', 서버에서 보내줄 데이터 타입
			contentType : 'application/x-www-form-urlencoded;charset=utf-8',
			
			suceess:function(data){ // 콜백 함수
				$.each(data, function(index, item){
					var output = '';
					output += '<tr>';
					output += '<td>' + item.id + '</td>';
					output += '<td>' + item.name + '</td>';
					output += '<td>' + item.job + '</td>';
					output += '<td>' + item.address + '</td>';
					output += '<td>' + item.bloodtype + '</td>';
					output += '<td><a href="/springajax/deletePeople.do" ';
					output += "class=delete_data ";
					output += 'id=' + item.id + '>삭제</a></td>';
					output += '</tr>'
					console.log("output = " + output);
					$('#output').append(output);
				});
			},
			error:function(){
				alert(" selectData() ajax 통신 실패");
			}
		});
	}
	
	/*
	(참고) 파일 첨부시 필요함
	- cache : false 로 선언 시 ajax로 통신 중 cache가 넘어가 갱신된 데이터를 받아오지 못할 경우를 대비
	- content type : false로 선언 시 content-type 헤더가 multipart/form-data로 전송되게 함
	- processData : false로 선언 시 formData를 String으로 변환하지 않음
	*/
	
	$(document).ready(function(){
		
		$('#input_data').click(function(event){
			var params = $('#insert_form').serialize(); // 주어진 데이터를 key-value로 직렬화해서 읽어오겠다.
			alert(params);
			
			jQuery.ajax({ // = $.ajax
				url : '/springajax/insertPeople.do',
				type : 'Post',
				data : params, // 서버로 보낼 데이터
	
				contentType : 'application/x-www-form-urlencoded;charset=utf-8',
				dataType : 'json', //서버에서 보내줄 데이터 타입
				success: function(retVal){
				   if(retVal.res=="OK"){
				      //데이터 성공일 때 이벤트 작성
				      selectData();
				      //초기화
				      $('#id').val('');
				      $('#name').val('');
				      $('#job').val('');
				      $('#address').val('');
				      $('#bloodtype').val('');
				   }
				   else{
				      alert("Insert Fail!!!");
				   }
				},
				error:function(){
				   alert("insert ajax통신 실패!!!");
				}

			});
			// 기본 이벤트 제거
			event.preventDefault();
		});
		
		$(document).on('click', '.delete_data', function(event){
			jQuery.ajax({
				url : $(this).attr('href'),
				type : 'POST',
				data : {'id' : $(this).attr("id")}, // 속성값 읽어오기 
				// 서버로 보낼 데이터
				contentType : 'application/x-www-form-urlencoded;charset=utf-8',
				dataType : 'json',
				success : function(retVal){
					if(retVal.res == "OK"){
						selectData();
					}
					else{
						alert("delete Fail !!!");
					}
				},
				error : function(){
					alert("delete ajax 통신 실패 !");
				}
			});
			//기본 이벤트 제거
			event.preventDefault();
		});
		
	selectData();
	});
</script>
</head>
	<form id="insert_form" method="post">
		<fieldset>
			<legend>데이터 추가</legend>
			<ul>
				<li>
					<label for="id">아이디</label>
					<input type="text" name="id" id="id"/>
				</li>
				<li>
					<label for="name">이름</label>
					<input type="text" name="name" id="name"/>
				</li>
				<li>
					<label for="job">직업</label>
					<input type="text" name="job" id="job"/>
				</li>
				<li>
					<label for="address">주소</label>
					<input type="text" name="address" id="address"/>
				</li>		
				<li>
					<label for="bloodtype">혈액형</label>
					<input type="text" name="bloodtype" id="bloodtype"/>
				</li>	
				<li>
					<input type="button" value="추가" id="input_data"/>
				</li>		
			</ul>
		</fieldset>
	</form>
	<form id="update_form" method="post">
	   <table id="output"></table>
	</form>

<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>