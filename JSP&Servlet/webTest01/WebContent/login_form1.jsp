<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 페이지</h2>
	
	<form action="login_test.jsp" method = "post">
		아이디 : <input type ="text" name = "userId">
		비밀번호 : <input type ="password" name = "userPwd">
		<button type ="submit">전송</button>
	</form>
</body>
</html>