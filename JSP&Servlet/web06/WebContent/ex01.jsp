<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>기본 출력문1</h3>
	
	<!-- Java의 데이터를 HTML 문서에 출력하는 방법 -->
	<%
		String hello = "안녕하세요.";
	%>
	
	<h4> 1. 스크립트릿을 이용한 방법</h4>
	<% out.println(hello); %>
	
	<h4> 2. 표현식 이용한 방법</h4>
	<%= hello %>
	
	<h4> 3. EL 표기법을 이용한 방법</h4>
	${hello}
	
	
</body>
</html>