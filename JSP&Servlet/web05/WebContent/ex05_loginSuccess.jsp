<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Member m = (Member)session.getAttribute("member");
	%>

	<h2><%=m.getName() %>(<%=m.getUserId() %>)님 환영합니다.</h2>
	로그아웃!
	
</body>
</html>