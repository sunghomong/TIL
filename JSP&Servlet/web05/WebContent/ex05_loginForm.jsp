<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인 프로그램</h3>
	<form action="loginServlet" method="post">
		아이디 : <input type="text" name="userId"> <br>
		비밀번호 : <input type="password" name="userPwd"> <br>
		<button type="submit">로그인</button>
	</form>
	 
</body>
</html>