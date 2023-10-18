<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>저장된 쿠키 삭제하기</h1>
	
	<%
		// 1. 같은 name의 쿠키를 저장하면 새로운 쿠키로 대체됨
		// 2. 유효시간 0초  => 쿠키를 간접적으로 삭제
		Cookie c1 = new Cookie("userId","hong");
		c1.setMaxAge(0);
		response.addCookie(c1);
		
	%>
	
	<a href = "ex02_getCookie.jsp">삭제된 쿠키 조회</a>
</body>
</html>