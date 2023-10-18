<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>기본 출력문 2</h3>
	<h4>기본 데이터 출력</h4>
	정수타입 : ${20} <br>
	실수타입 : ${3.14 }<br>
	문자열 : ${"힘쎄고 강한 아침!" }<br>
	논리타입 : ${false } <br>
	null : ${null }<br>
	<hr>
	
	<h4>연산 결과 출력</h4>
	5+2 : ${5+2}<br>
	5-2 : ${5-2}<br>
	5*2 : ${5*2}<br>
	5/2 : ${5/2}<br>
	5%2 : ${5%2}<br>
	<hr>
	5>2 : ${5>2}<br>
	5>2 : ${5 gt 2}<br>
	<hr>
	(5>2)?5:2 => ${(5>2)?5:2}<br>
	(5>2)?"합격":"불합격" => ${(5>2)?"합격":"불합격"}<br>
	<hr>
	
	
</body>
</html>