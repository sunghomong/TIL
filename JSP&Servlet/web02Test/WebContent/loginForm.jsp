<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 폼</h1>
	
	<%
	session.setAttribute("userId", "조성호");
	session.setAttribute("userPw", "1234");
	%>
	
	
	<form action="testLogin.jsp" method = "get">
		아이디 : <input type = "text" name = "id"><br>
		비밀 번호 : <input type = "password" name = "pw"><br>
		<button type = "submit">로그인 </button>
	</form>
</body>
</html>