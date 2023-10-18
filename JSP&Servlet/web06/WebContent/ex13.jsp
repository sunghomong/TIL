<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String names = "강민지:김성일;김한결:김회진;박민수:박한규;신예훈:신현식;양광석:이재안;이창호:정시화;정지윤:조성호;조소윤";
		pageContext.setAttribute("names",names);
	%>
		<h3>문자열 쪼개기</h3>
		<c:forTokens var = "name" items="${names}" delims=":;">
			${name} <br>
		</c:forTokens>
		
</body>
</html>