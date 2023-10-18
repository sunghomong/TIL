<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 조회</h1>
	<%
		String userId = (String) session.getAttribute("userId");
		String userPwd = (String) session.getAttribute("userPwd");
	%>
	
	아이디 : <%= userId %><br>
	비밀번호 : <%= userPwd %><br>
	이름 : <%= session.getAttribute("username") %><br>
	<br>
	<br>
	<br>
	<h4>전체 데이터 조회</h4>
	
	<%
		Enumeration<String> names = session.getAttributeNames(); // 세션에 저장된 모든 어트리뷰트 이름 가져오기
		
		while(names.hasMoreElements()){
			String name = names.nextElement().toString(); // 세션에 저장된 어트리뷰트 이름을 하나씩 가져오기
			String value = session.getAttribute(name).toString();
	%>			
			<%= name %> : <%= value %> <br> <!-- 중간에 html 삽입 방법 --> 
	<%			
		}
	%>
	
	<a href="ex03_removeSession.jsp">세션 전체 삭제</a>
	
	
</body>
</html>