<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String userId = (String) session.getAttribute("userId");
		String userPw = (String) session.getAttribute("userPw");
		
		
		
		if(userId.equals(request.getParameter("id")) && userPw.equals(request.getParameter("pw"))) {
			
			session.setAttribute("loginCheck", "ok");
			response.sendRedirect("main.jsp");
		}else{
			
			
			out.println("<script>alert('잘못 입력하셨습니다.');</script>");
			out.println("<script>location.href = 'main.jsp'</script>");
		}
		
	%>
</body>
</html>