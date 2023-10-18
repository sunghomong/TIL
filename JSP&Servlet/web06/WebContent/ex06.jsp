<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>내장 객체에 저장된 값 출력</h3>

	<%
		// request객체에 값을 저장
	request.setAttribute("num1", 10);
	request.setAttribute("num2", 20);
	%>

	1. 표현식에서의 합계 출력
	<%=request.getAttribute("num1")%>
	+
	<%=request.getAttribute("num2")%>
	=
	<%=(Integer)request.getAttribute("num1") + (Integer)request.getAttribute("num2")%>
	<hr>
	2. 표현식에서의 합계 출력[수정] <br>
	<%
	int num1 = (Integer)request.getAttribute("num1");
	int num2 = (Integer)request.getAttribute("num2");
	%>
	<%=num1 %> + <%=num2 %> = <%=num1 + num2 %>
	
	<hr>
	3. EL 표기법에서의 합계 출력[수정] <br>
	${num1} + ${num2} = ${num1 + num2} <br>

</body>
</html>