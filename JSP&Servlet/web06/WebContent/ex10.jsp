<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL 사용법</h3>
	1. 변수 선언 :set
	<c:set var="msg" value="안녕1" scope="request"/>
	<br>
	<%
		request.setAttribute("msg2","안녕2"); 
	%>
	<br>
	
	2. 변수 출력 :out
	<c:out value="${msg1}"/>
	<br>
	<%=request.getAttribute("msg1").toString() %>
	<br>
	${msg1}
	<br>
	
	3. 변수 선언의 응용
		3-1. EL 출력으로 나오는 데이터도 변수로 저장 가능
		<c:set var = "add" value="${10+20}"/>
		합계 : ${add}
		<br>
		
		3-2. 저장되는 데이터를 열기태그와 닫기 태그 사이에 작성 가능<br>
		<c:set var="bool">
			${10>20}
		</c:set>
		10>20 = <c:out value="${bool}"/>
		
		3-3. 저장되는 데이터는 자바빈 객체도 가능 <br>
		<c:set var = "member" value="<%=new domain.Member() %>"/>
		<c:set target="${member}" property="userName" value="홍길동"/>
		<c:set target="${member}" property="userId">
			의적
		</c:set>
		
		이름 : ${member.userName} <br>
		아이디 : <c:out value="${member['userId']}"/> <br>
		
	4. 변수의 삭제 <br>
		<c:set var="test" value="테스트"/>
		변수 선언 후 테스트 결과 : ${test} <br>
		<c:remove var="test"/>
		변수 삭제후 테스트 결과 : ${test} <br>
		
		
</body>
</html>