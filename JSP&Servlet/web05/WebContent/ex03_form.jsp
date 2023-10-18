<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 가입 폼</h2>
	<form action="ex03_result.jsp" method="post">
		이름 : <input type="text" name="name"> <br>
		아이디 : <input type="text" name="userId"> <br>
		별명 : <input type="text" name="nickName"> <br>
		비밀번호 : <input type="password" name="userPw"> <br>
		이메일 : <input type="email" name="email"> <br>
		전화번호 : <input type="tel" name="phone"> <br>
		<button type="submit">회원가입</button>
	</form> 
</body>
</html>