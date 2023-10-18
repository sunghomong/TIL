<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	컨텍스트 패스 : <%=request.getContextPath() %> <br>
	요청 방식 : <%=request.getMethod() %> <br>
	요청한 URL : <%=request.getRequestURL() %> <br>
	요청한 URI : <%=request.getRequestURI() %> <br>
	서버 이름 : <%=request.getServerName() %> <br>
	포트 번호 : <%=request.getServerPort() %> <br>
	프로토콜 : <%=request.getProtocol() %> <br>
	
	<a href="ex03.jsp">SendRedirect 예제</a> <%--forward와 다르게 주소를 이동 --%>
	<a href="ex04.jsp">Forward 예제</a> <%--send redirect (client이동) 
										<-> forward (server의 이동)의 차이를 잘 알아둘 것 --%>
										 <%-- 주소창이 바뀌지 않은채 이동 --%>
	<a href = "ex05_loginForm.jsp">로그인 페이지로 이동</a>
	
</div>
</body>
</html>