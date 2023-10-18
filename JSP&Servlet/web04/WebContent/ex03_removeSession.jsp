<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 삭제</h1>
	<%
		session.invalidate();
	%>
	
	<a href = "ex03_getSession.jsp">세션 삭제 확인</a>
</body>
</html>