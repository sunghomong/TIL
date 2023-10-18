<%@ page import = "domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>리퀘스트에 저장된 자바빈 프로퍼티 꺼내보기</h3>
	<%
		// 1. 자바 빈 객체 생성
		Member member = new Member();
	
		// 2. 생성된 자바빈에 프로퍼티 데이터 삽입
		member.setUserId("Green");
		member.setUserName("강그린");
		
		// 3. 리퀘스트 객체에 자바빈 데이터 저장
		request.setAttribute("member",member);
		
	%>
	이름 : ${requestScope.member.userName} <br>
	아이디 : ${member["userId"]}<br>
	
	
	
	
</body>
</html>