<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>기존방식으로 자바빈 객체 출력</h3>
	<%
		Member m3 = (Member)request.getAttribute("m3");
	%>
	아이디 : <%=m3.getUserId() %> <br>
	이름 : <%=m3.getName() %>
	
	<hr>
	<h3>액션태그를 통한 자바빈 객체 출력</h3>
		
	<jsp:useBean id="m4" class="domain.Member" scope="request">
	</jsp:useBean>
	
	<jsp:setProperty name="m4" property="name" value='<%=request.getParameter("name") %>' />
	<%--							   setName()		     --%>
	<jsp:setProperty name="m4" property="userId" value='<%=request.getParameter("userId") %>' />
	
	아이디 : <jsp:getProperty name="m4" property="userId" /><br>
	<%--										  getUserId()	 --%>
	이름 : <jsp:getProperty name="m4" property="name" /><br>
	
	
</body>
</html>