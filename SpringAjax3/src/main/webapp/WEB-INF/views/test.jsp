<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<button id="ajaxButton" type="button">Make a request</button>

<script>

(function(){
	
	var httpRequest;
	document.getElementById("ajaxButton").addEventListener('click', makeRequest);
	
	function makeRequest(){
		
		httmRequest = new XMLHttpRequest();
		
		if(!httpRequest){
			alert("xmlHttp��û ���� �� ����");
			return false;
		}
		httpRequest.onreadystatechange = alertContents;
		httpRequest.open('GET', '/springajax3/ajax.do');
		httpRequest.send();
	}
	
	function alertContents(){
		if(httpRequest.readyState === XMLHttpRequest.DONE){
			if(httpRequest.status === 200){
				alert(httpRequest.responseText);
			}
			else{
				alert('request�� ���� ������ �־��.')
			}
		}
	}
	
})();
</script>
</body>
</html>