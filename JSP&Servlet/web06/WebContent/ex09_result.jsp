<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>선택된 색깔 출력</h3>

	<%
		int selectNum = Integer.parseInt(request.getParameter("color"));

	if (selectNum == 1) {
		out.println("<span style = 'color : red;'>빨강</span>");
	} else if (selectNum == 2) {
	%>
	<span style="color: blue;">파랑</span>
	<%
		} else if (selectNum == 3) {
	%>
	<span style="color: green;">초록</span>
	<%
		}
	%>






</body>
</html>