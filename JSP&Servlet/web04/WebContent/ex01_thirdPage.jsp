<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 세번째 페이지 </h1>
하나의 페이지 속성 : <%=pageContext.getAttribute("nmae") %><br>
하나의 요청 속성 : <%=request.getAttribute("nmae") %><br>
하나의 세션 속성 : <%=session.getAttribute("nmae") %><br>
하나의 어플리케이션 속성 : <%=application.getAttribute("nmae") %><br>

</body>
</html>