<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 조회</h1>
	<%
		Cookie[] cookies= request.getCookies();
	
		for(Cookie c : cookies) {
			out.println(c.getName() + " : " + c.getValue() + "<br>");
		}
	
	%>
	
	<a href = "ex02_removeCookie.jsp">쿠키 삭제</a>
</body>
</html>