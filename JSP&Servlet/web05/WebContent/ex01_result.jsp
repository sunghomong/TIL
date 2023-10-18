
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
	<h3> 자바빈에 저장된 데이터 출력하기 </h3>
	<%
		// 내장 객체에 저장된 자바빈 꺼내보기
		Member m2 = (Member)request.getAttribute("member1");
	
		// 자바빈에 저장된 데이터 꺼내보기
		String name = m2.getName();
		String userId = m2.getUserId();
		
	%>
	<h4>데이터 출력하기 1</h4>
	아이디 : <%=userId %><br>
	이름 : <%=name %>
	<br>
	<h4>데이터 출력하기 2</h4>
	아이디 : <%=m2.getUserId() %><br>
	이름 : <%=m2.getName() %>
	
	
	
</body>
</html>