<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>파라미터 숫자 덧셈</h3>
	1. 표현식에서의 연산<br>
	<%=request.getParameter("num1") %> + <%=request.getParameter("num2") %> = 
	<%=request.getParameter("num1") + request.getParameter("num2") %>
	<hr>
	2. 표현식에서의 연산[수정] <br>
	<%
		String str1 = request.getParameter("num1");
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(request.getParameter("num2"));
	%>
	<%=num1 %> + <%=num2 %> = <%=num1 + num2 %>
	<hr>
	3. EL 표기법에서의 연산 <br>
	${param.num1} + ${param.num2} = ${param.num1 + param.num2}<br>
	${param.num1}${param.num2}
	
</body>
</html>