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
	<h3>기존의 방식으로 자바빈 객체 만들어서 저장하기</h3>
	<%
	Member m3 = new Member();
	m3.setUserId("Heart");
	m3.setName("하츄핑");
	
	request.setAttribute("m3", m3);

// 	포워드
//	request.getRequestDispatcher("ex02_result.jsp").forward(request, response);

	%>
	
	<h3>액션태그를 이용해서 자바빈 객체를 만들어서 저장하기</h3>
	
	<jsp:forward page="ex02_result.jsp" >
		<jsp:param value="행운핑" name="name" />
		<jsp:param value="lucky" name="userId" />
	</jsp:forward>
	
	
</body>
</html>