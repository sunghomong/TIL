<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1. 선언부 -->
	<%! // => 선언부 
	// 스크립트릿+느낌표(!)로 시작하는 부분이 선언부다!!
	
	// index_jsp.java 클래스의 필드로서 사용되는 변수
	int test01 = 10;
	
	public void check() {
		System.out.println("메서드 동작!");
	}
	public String str() {
		return "반갑습니다.";
	}
	
	
	%>
	
	<!-- 2. 스크립트릿 -->
	<% // "<%" : 스크립트릿 태그 라고 부른다. 이 안에는 자바 코드를 입력할 수 있다.
	// _JspService라는 메서드 내부, 이 안에서 메서드를 생성할 수 없다. 위의 선언부에서는 가능하다. 
	String name = "홍길동";
	int num = 98;
	
	out.println("<p>"+name+"</p>");
	/*public void check() {
		System.out.println("메서드 동작!");
	}*/
	
	List<String> lists = new ArrayList<>();
	%>
	
	<!-- 3. 표현식 -->
	<p><%=name %></p> <!-- name이라는 변수 안의 데이터(홍길동)를 꺼내서 출력하라는 의미 (out.print를 대체한다.)-->
	<p><%=str() %></p> <!-- str()의 return값을 출력한다. -->
	
	<!-- HTML주석 -->
	<%-- JSP 주석 --%>
	
	<a href="errorCheck.jsp">에러 페이지 테스트</a> <br><!-- 일종의 try catch -->
	
	<a href="firstPage.jsp">프론트 페이지로 이동</a>
	
</body>
</html>