<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입 (MVC1)</h3>
	<form action="ex04_join.jsp" method="post">
		이름 : <input type="text" name="name"><br>
		아이디 : <input type="text" name="userid"><br>
		비밀번호 : <input type="password" name="userpwd"><br>
		이메일 : <input type="email" name="email"><br>
		전화번호 : <input type="tel" name="phone"><br>
		<input type="radio" name="admin" value="1">관리자
		<input type="radio" name="admin" value="0" checked>사용자
	 	<button type="submit">회원가입</button>
	 	<button type="reset">다시 작성</button>
	</form>    
</body>
</html>