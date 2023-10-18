<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty loginUser}">
	<c:redirect url="login"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전용 페이지</title>
</head>
<body>
	<h2>회원 전용 페이지</h2>
	<p>
		안녕하세요. ${loginUser.name}(${loginUser.userid})님 환영합니다.
	</p>
	<form action="logout" method="get">
		<button type="submit">로그 아웃</button>
	</form>
	<%-- 
		세션에 회원 정보가 이미 있지만
		DBMS로 부터 회원 정보를 가져와서 수정 폼에 보여줄 예정 
	--%>
	<button type="button" onclick="location.href='memberUpdate?userid=${loginUser.userid}'">회원 정보 변경</button>
	 									<%-- memberUpdate서블릿의 doGet으로 이동  --%>	
	
	
	
	
	
	
	
</body>
</html>



