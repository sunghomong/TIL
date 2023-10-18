<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 생성</h1>
	
	<%
	// 1. 쿠키 객체를 생성합니다. (4KB * 300 = 1.2MB)
	Cookie c1 = new Cookie("userId","hong");
	
	// 2. 쿠키 객체에 설정을 추가(선택 사항)
	
	// 3. 클라이언트에게 쿠키를 전송
	response.addCookie(c1);
	
	response.addCookie(new Cookie("userpwd","1234"));
	response.addCookie(new Cookie("username","홍길동"));
	
	%>
</body>
</html>