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
	// 각 내장 객체에 데이터를 저장
	pageContext.setAttribute("name","page Data");
	request.setAttribute("name","request Data");
	session.setAttribute("name","session Data");
	application.setAttribute("name","application Data");

	// 각 내장 겍체에 데이터를 출력
	System.out.println("--- ex01_firstPage.jsp ---");
	System.out.println("하나의 페이지 속성 : " + pageContext.getAttribute("name"));
	System.out.println("하나의 요청 속성 : " + request.getAttribute("name"));
	System.out.println("하나의 세션 속성 : " + session.getAttribute("name"));
	System.out.println("하나의 어플리케이션 속성 : " + application.getAttribute("name"));
	
	request.getRequestDispatcher("ex01_secondPage.jsp").forward(request, response);
	
	
%>
</body>
</html>