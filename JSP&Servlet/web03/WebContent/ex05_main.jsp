<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.net.URLDecoder" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 성공</h1>
	
	<p>
		<%-- <%= URLDecoder.decode(request.getParameter("name")) %>님 환영합니다. --%>
		<%= (String)request.getAttribute("name") %>(<%= request.getParameter("userid") %>)님 환영합니다.
	</p>
	
	<hr>
	<p> 저희 홈페이지 방문해 주셔서 감사합니다. </p>
</body>
</html>