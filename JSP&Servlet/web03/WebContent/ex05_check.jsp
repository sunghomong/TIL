<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.net.URLEncoder" %>
    
<%
	String storedId = "green";
	String storedPassword = "1234";
	String storedName = "홍인형";
	
	String userId = request.getParameter("id");
	String userPassword = request.getParameter("pw");
	
	if(storedId.equals(userId) && storedPassword.equals(userPassword)){
		//로그인 성공
		// response.sendRedirect("ex05_main.jsp?name=" + URLEncoder.encode(storedName, "UTF-8"));
							// ex05_main.jsp?name= 홍인형
		request.setAttribute("name",storedName);
									
		request.getRequestDispatcher("ex05_main.jsp").forward(request, response);
	}else{
		// 로그인 실패
		response.sendRedirect("ex05_loginFail.jsp");
	}
%>