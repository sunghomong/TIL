<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 등록</h1>
	<%
		session.setAttribute("userId", "hong");
		session.setAttribute("userPwd", "1234");
		session.setAttribute("username", "홍길동");
	%>
</body>
</html>