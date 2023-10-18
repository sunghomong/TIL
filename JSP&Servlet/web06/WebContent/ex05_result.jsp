<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>문자열 비교</h3>
	1. 표현식에서의 비교<br>
	== 연산자 사용결과 : <%=request.getParameter("name") == "홍길동" %> <br>
	equals 메서드 사용결과 : <%=request.getParameter("name").equals("홍길동")%> <br>
	
	<hr> 
	2. EL 표기법에서의 비교 <br>
	== 연산자 사용결과 : ${param["name"] == "홍길동"} <br>
	
</body>
</html>