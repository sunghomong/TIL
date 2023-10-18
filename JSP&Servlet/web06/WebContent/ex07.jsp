<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>내장 객체에서의 출력</h3>
	<%
		pageContext.setAttribute("name", "페이지");
		request.setAttribute("name","리퀘스트");
		session.setAttribute("name", "세션");
		application.setAttribute("name","어플리케이션");
	%>
	
	<h4>EL 표기법으로 내장 객체의 데이터를 출력 (~scope)</h4>
	Page에 저장된 속성 값 : ${pageScope.name} <br>
	Request에 저장된 속성 값 : ${requestScope["name"] } <br>
	session에 저장된 속성 값 : ${sessionScope.name }<br>
	application에 저장된 속성 값 : ${applicationScope["name"] } <br>
	
	<hr>
	name 속성 값 : ${name} <br>
	
	<!-- 
		1. 내장 객체에 저장된 속성의 값을 출력할 때는 재장 객체 정보를 생략할 수 있다.
		
		2. 각 재장 객체에 같은 이름의 속성명이 존재하는 경우에는 우선 순위에 의해서 출력 여부를 결정
		
			page -> request -> session -> application -> null
	 -->
</body>
</html>