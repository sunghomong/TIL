<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		
		background-color: #333;
		display: flex;
		
		
		}
		form{
			width: 300px;
			height: 300px;
			background-color: #666;
			text-align: center;
			margin: auto;
			padding-top: 100px;
			box-sizing: border-box;
			margin-top: 100px;
			}
		
		.te  {
			margin-top: 10px;
			width: 200px;
			height: 20px;
			
		}


		button{
			width: 100px;
			margin-top: 20px;
			cursor: pointer;
			
		}
</style>

</head>
<body>
	<form action="ex05_check.jsp" method = "get">
		ID : <input type = "text" name = "id" class="te"> <br>
		PW : <input type = "text" name = "pw" class="te"> <br>
		<button type = "submit" > 전송 </button>
	</form>
</body>
</html>