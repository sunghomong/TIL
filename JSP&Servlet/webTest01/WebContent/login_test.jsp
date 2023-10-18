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
	<!-- 2단계 로그인 프로그램 -->
	<!-- 로그인 폼을 만들고 아이디와 비밀번호를 입력하면 이미 저장된 아이디와 비밀번호(green/1234)를 비교해서 둘다 일치하면 로그인 성공페이지로 이동하고
	둘중 하나라도 일치하지 않으면 로그인 실패 페이지로 이동하도록 코드를 작성하세요. -->
	<c:choose>
		<c:when
			test="${(param.userId eq 'green') && (param.userPwd eq '1234')}">
			<c:redirect url="login_success.jsp" />
		</c:when>
		<c:otherwise>
			<c:redirect url="login_false.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>