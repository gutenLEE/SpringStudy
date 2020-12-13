<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    </style>
    

    
</head>
<body>
    <section class="containers">
        <form method="POST"  action="./loginProcess.me" name="loginform">
            <table id = "table">
                <tr id="table-head">
                	<p>Bitcamp portal Login</p><br>	
                	
                	<% 
                	if(request.getParameter("hakbun") != null){ 
                	%>
                	<p>회원가입이 완료되었슴. 로그인 해주쇼</p>
                	<%} %>
                	
                </tr>
                <tr>
                    <td>학번</td>
                    <td><input type="text" name="hakbun"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td id="table-login-btn">
                        <a href="javascript:loginform.submit()">로그인</a>
                    </td>
                    <td id="table-login-btn">
                        <a href="./joinform.me">회원가입</a>
                    </td>
                </tr>

            </table>
        </form>
    </section>
    
     <script type="text/javascript">
    	function loginhandler () {
	  		var tableElem = document.querySelector("#table");
	  		tableElem.setAttribute("style", "border: 1px solid red;");
    		
	  		var rows = tableElem.rows.length;
	  		
	  		var row = tableElem.insertRow(rows);
	  		var cell = row.insertCell(0);
	  		cell.innerText = "로그인 실패";
    	}
    	
    	var loginFail = <%=request.getParameter("login_flag") %> 

 
  		if(loginFail != null && loginFail == 0 ){
	   		alert("fhrl 실패");
	   		loginhandler();
   		}
    </script>
    
</body>
</html>