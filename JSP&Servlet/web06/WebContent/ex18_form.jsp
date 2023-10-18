<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> POST 전송시 한글 깨짐 현상 </h3>
	<form action="ex18_encoding1.jsp" method="post">
		이름 : <input type = "text" name = "name">
		<button type = "submit">전송</button>
	</form>
	<hr>
	
	<h3> POST 전송시 한글 깨짐 방지 - request객체 </h3>
	<form action="ex18_encoding2.jsp" method="post">
		이름 : <input type = "text" name = "name">
		<button type = "submit">전송</button>
	</form>
	<hr>
	
	<h3> POST 전송시 한글 깨짐 방지 - format 태그 라이브러리 </h3>
	<form action="ex18_encoding3.jsp" method="post">
		이름 : <input type = "text" name = "name">
		<button type = "submit">전송</button>
	</form>
	<hr>
</body>
</html>