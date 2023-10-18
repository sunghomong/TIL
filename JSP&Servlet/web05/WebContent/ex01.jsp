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
	<h3>자바빈 활용방법</h3>
	
	<% // 자바빈 활용방법 : 자바 객체 활용법
	
	Member m1 = new Member();
	
	m1.setName("고길동");
	m1.setUserId("ko");
	
	// 만들어진 자바빈을 다른 페이지에 넘겨주기 위해서 내장객체에 저장
	request.setAttribute("member1", m1); // 응답되기 전 페이지에서 활용하기 위해서
	session.setAttribute("member1", m1); // 응답된 후 다른 페이지에서 활용하기 위해서
	
	
	// 포워드 이동
	request.getRequestDispatcher("ex01_result.jsp").forward(request,response);
		
	
	
	%>
	
</body>
</html>